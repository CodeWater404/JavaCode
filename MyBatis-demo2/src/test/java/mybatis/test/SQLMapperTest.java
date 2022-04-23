package mybatis.test;

import mybatis.mapper.SQLMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.*;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-16-16:10
 * @Function Description ：
 * 特殊sql的执行测试
 */
public class SQLMapperTest {
    //    <!--模糊查询：尽量用第三种；#{}不能直接用（因为它是会自动加上‘’的）；-->
    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByLike("a");
        System.out.println(list);
    }

    //    <!--使用删除的时候不能用#{}，因为他会自动加上‘’ ，导致格式不正确虽然在idea中执行并不会报错，但
//    没有真正操控到数据。  所以只能使用${}-->
    @Test
    public void testDeleteMore() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        int result = mapper.deleteMore("1,2 , 3");
        System.out.println(result);
    }


    //    <!--动态查询指定表：同样因为#{}会自动加上‘’所以不能用；因为表名不需要加单引号-->
    @Test
    public void testGetUserByTableName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = mapper.getUserByTableName("t_user");
        System.out.println(list);
    }

    //    <!--测试添加功能，jdbc封装有有自增的逐主键，所以mybatis可以，在xml标签中设置了-->
    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "王五", "111", 23, "女", "98934@qq.com");
        mapper.insertUser(user);
        System.out.println(user);
    }

    //    采用JDBC的步骤(不要测试)
    @Test
    public void testJDBC() throws Exception {
        Class.forName("");
        Connection connection = DriverManager.getConnection("", "", "");
//    获取自动递增的主键
        PreparedStatement ps = connection.prepareStatement("insert", Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        ResultSet resultSet = ps.getGeneratedKeys();
    }
}
