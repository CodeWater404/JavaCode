package codewater.mapper;
import codewater.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Entity codewater.pojo.User
 */
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

}




