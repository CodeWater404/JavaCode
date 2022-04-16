package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-16-16:02
 * @Function Description ：
 */
public interface SQLMapper {
//    <!--模糊查询：尽量用第三种；#{}不能直接用（因为它是会自动加上‘’的）；-->
    List<User> getUserByLike(@Param("username") String username );
    
//批量删除：    使用删除的时候不能用#{}，因为他会自动加上‘’ ，导致格式不正确虽然在idea中执行并不会报错，但
//    没有真正操控到数据。  所以只能使用${}
    int deleteMore(@Param("ids") String ids);
    
//    <!--动态查询指定表：同样因为#{}会自动加上‘’所以不能用；因为表名不需要加单引号-->
    List<User> getUserByTableName(@Param("tableName") String tableName);
    
//  添加用户：  <!--测试添加功能，有自增的逐主键-->
    void insertUser( User user);
}
