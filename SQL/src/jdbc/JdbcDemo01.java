package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author ： CodeWater
 * @create ：2022-03-08-15:10
 * @Function Description ：jdbc的快速入门
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelExample" , "root" , "root" );
        
        String sql = "show tables";
        Statement stmt = conn.createStatement();
        
        int count = stmt.executeUpdate( sql );
        System.out.println( count );
        
        stmt.close();
        conn.close();
    }
}
