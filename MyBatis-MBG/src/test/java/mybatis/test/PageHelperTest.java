package mybatis.test;

import com.github.pagehelper.PageInfo;
import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-17-19:41
 * @Function Description ：
 * 分页插件的测试
 * 
 * limit index,pageSize
 * index:当前页的起始索引（需要减1）
 * pageSize：每页显示的条数
 * pageNum：当前页的页码
 * index=(pageNum-1)*pageSize
 * 
 * 使用MyBatis的分页插件实现分页功能：
 * 1、需要在查询功能之前开启分页
 * PageHelper.startPage(int pageNum, int pageSize);
 * 2、在查询功能之后获取分页相关信息
 * PageInfo<Emp> page = new PageInfo<>(list, 5);
 * list表示分页数据
 * 5表示当前导航分页的数量
 * 
 */
public class PageHelperTest {
    
    @Test
    public void testPageHelper(){
        try{
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build( is );
            SqlSession sqlSession = sqlSessionFactory.openSession( true );
            EmpMapper mapper = sqlSession.getMapper( EmpMapper.class );
//            在查询之前开启分页 , 第一页每页显示5条数据
//            PageHelper.startPage( 1 , 5 );
            
//            获取page对象
//            Page<Object> page = PageHelper.startPage( 1 , 5 );
            
            List<Emp> list = mapper.selectByExample( null );
            list.forEach( emp -> System.out.println( emp ) );
            
//            在分页之后，获取所有的page信息
            PageInfo<Emp> page = new PageInfo<>( list , 3 );
            
            System.out.println( page );
            
            
        }catch ( IOException e ){
            e.printStackTrace();
        }
        
    }
}
