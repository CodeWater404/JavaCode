package mybatis.test;

import mybatis.mapper.CacheMapper;
import mybatis.pojo.Emp;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author ： CodeWater
 * @create ：2022-04-17-14:50
 * @Function Description ：
 */
public class CacheMapperTest {
    //    测试一级缓存（只对查询有用）的范围：sqlSession.缓存的是同一个条件的
    @Test
    public void testOneCache() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);
//        sql只会执行一次,控制台只输出一个sql
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);

//        //    测试增删改会清空缓存
//        mapper1.insertEmp(new Emp( null , "hha" , 24 , "" , " " ,null));

//      清空缓存，一级缓存失效
        sqlSession.clearCache();


        Emp emp2 = mapper1.getEmpById(1);
        System.out.println(emp2);
//        CacheMapper mapper2 = sqlSession.getMapper( CacheMapper.class );
//        Emp emp3 = mapper2.getEmpById( 1 );
//        System.out.println( emp3 );

//       在创建一个SQLSession，sql就会执行2次，输出2个
//        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
//        CacheMapper mapper3 = sqlSession2.getMapper( CacheMapper.class );
//        Emp emp4 = mapper3.getEmpById( 1 );
//        System.out.println( emp4 );

    }

    //    尔集缓存需要满足多个条件;,任意增删改也会清除二级，但是手动清空缓存不会清空二级的
    @Test
    public void testTwoCache() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpById(1));
//            SQLSession必须关闭或者提交之后，二级缓存才有效！
            sqlSession1.close();
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpById(1));
            sqlSession2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
