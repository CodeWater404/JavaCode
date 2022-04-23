package jspCase.dao.impl;

import jspCase.dao.UserDao;
import jspCase.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import jspCase.util.JDBCUtils;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-03-17-15:00
 * @Function Description ：
 */

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public List<User> findAll() {
        String sql = "select * from jspcase_user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
}
