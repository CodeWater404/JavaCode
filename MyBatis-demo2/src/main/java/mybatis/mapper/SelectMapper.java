package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-04-15-22:50
 * @Function Description ：
 */
public interface SelectMapper {
    //    返回值集合，单个
    List<User> getUserById(@Param("id") Integer id);

    //    返回值集合，所有
    List<User> getAllUser();

    //    查询返回整数类型
    Integer getCount();

    //    查询返回值是map,一个数据
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    //    查询返回值是list集合,里面存储的多个数据是map类型
    List<Map<String, Object>> getAllUserToMapList();

    //    查询返回值是,多个数据,用注解
    @MapKey("id")
    Map<String, Object> getAllUserToMapAnnotation();
}
