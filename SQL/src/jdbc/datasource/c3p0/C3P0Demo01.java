package jdbc.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ： CodeWater
 * @create ：2022-03-10-15:42
 * @Function Description ：c3p0的演示
 */
public class C3P0Demo01 {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();

        System.out.println(conn);
    }
}
