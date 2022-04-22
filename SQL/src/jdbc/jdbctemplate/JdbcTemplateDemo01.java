package jdbc.jdbctemplate;

import jdbc.util.JDBCUtils2;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author ： CodeWater
 * @create ：2022-03-10-15:46
 * @Function Description ：
 * jdbctemplate入门
 */
public class JdbcTemplateDemo01 {

    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils2.getDataSource());
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql, 3);
        System.out.println(count);
    }
}
