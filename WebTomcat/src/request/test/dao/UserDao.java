package request.test.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import request.test.domain.User;
import request.test.util.JDBCUtils;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-12:12
 * @Function Description ：
 * 操作数据库中User表的类
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    //登录方法
    public User login(User loginUser) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
