package mybatis.test;

import mybatis.mapper.EmpMapper;
import mybatis.pojo.Emp;
import mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ： CodeWater
 * @create ：2022-04-17-16:59
 * @Function Description ：
 */
public class MBGTest {
    @Test
    public void testMBG() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//            查询所有数据，null没有条件就是所有
//            List<Emp> list = mapper.selectByExample( null );
//            list.forEach( emp -> System.out.println( emp ));

//            根据条件来查询，有提供对应的方法
            EmpExample example = new EmpExample();
//            example.createCriteria().andEmpNameEqualTo( "田七" );
//            还可以继续加条件
//            example.createCriteria().andEmpNameEqualTo( "田七" ).andAgeGreaterThanOrEqualTo( 23 );
//            在and后面 继续加or
//            example.createCriteria().andEmpNameEqualTo("田七").andAgeGreaterThanOrEqualTo( 23 );
//            example.or().andDidIsNotNull();
//            List<Emp> list = mapper.selectByExample( example );
//            list.forEach( emp -> System.out.println( emp ) );

//            根据主键修改,如果参数有null也会修改数据库
//            mapper.updateByPrimaryKey( new Emp( 1 , "admin" , 25 , "男" , "123" , null ));
//            根据主键选择性修改，遇到null参数就不会更新数据库中的字段(注意，参数null直接写不会修改数据库；如果“null”有引号还是会修改！！！！)
            mapper.updateByPrimaryKeySelective(new Emp(1, "zhasnag", null, "男", null, null));

//            插入的功能也类似
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
