package mybatis.test;

import mybatis.mapper.ParameterMapper;
import mybatis.pojo.User;
import mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-04-15-18:18
 * @Function Description ：
 * <p>
 * MyBatis获取参数值的两种方式：${}和#{}
 * ${}本质字符串拼接
 * #{}本质占位符赋值
 * MyBatis获取参数值的各种情况：
 * 1、mapper接口方法的参数为单个的字面量类型
 * 可以通过${}和#{}以任意的名称获取参数值，但是需要注意${}的单引号问题
 * <p>
 * 2、mapper接口方法的参数为多个时
 * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
 * a>以arg0,arg1...为键，以参数为值
 * b>以param1,param2...为键，以参数为值
 * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
 * <p>
 * 3、若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
 * 只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
 * <p>
 * 4、mapper接口方法的参数是实体类类型的参数(重要)
 * 只需要通过#{}和${}以属性的方式访问属性值（get那里的）即可，但是需要注意${}的单引号问题
 * <p>
 * 5、使用@Param注解命名参数
 * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
 * a>以@Param注解的值为键，以参数为值
 * b>以param1,param2...为键，以参数为值
 * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
 */
public class ParameterMapperTest {
//    @Test
//    public void testCheckLoginByParam(){
//        SqlSession sqlSession = Sq
//    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

    //    通过参数获取对应的信息
    @Test
    public void testGetUserByUsername() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);
    }

    //    多个参数获取信息
    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin", "123456");
        System.out.println(user);
    }

    //    多个参数，但是用注解设置固定的名字传入sql
    @Test
    public void testCheckLoginByPara() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("admin", "123456");
        System.out.println(user);
    }

    //    参数是map，自定义paramterMapper.xml中传输的参数名
    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
//        map的键会传入到sql对应的参数名那；值会代替参数
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
//        把map传入方法
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    //    接口方法参数是实体类型
    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int result = mapper.insertUser(new User(null, "李四", "123", 23, "男", "123@qq.com"));
        System.out.println(result);
    }
}
