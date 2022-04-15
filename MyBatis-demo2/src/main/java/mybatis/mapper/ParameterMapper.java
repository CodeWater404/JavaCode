package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-04-15-18:19
 * @Function Description ：
 */
public interface ParameterMapper {
//    查询所有用户信息
    List<User> getAllUser();
//    根据用户名查询用户信息
    User getUserByUsername(String username);
//    多个参数
    User checkLogin( String name , String password );
//    多个参数，但是用注解设置固定的名字传入sql
    User checkLoginByParam(@Param("username") String username , @Param("password") String password);
//    把多个参数放入map，自定义键名当参数传入sql语句
    User checkLoginByMap( Map<String , Object> map );
//    参数是实体
    int insertUser(User user);

}
