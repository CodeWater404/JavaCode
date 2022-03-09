package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

/**
 * @author ： CodeWater
 * @create ：2022-03-09-10:30
 * @Function Description ：执行DDL语句
 */
public class JdbcDemo06 {
    public static void main(String[] args){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3" , "root" , "root" );
            String sql = "select * from account";
            stmt = conn.createStatement();
            rs = stmt.executeQuery( sql );
            rs.next();
            int id = rs.getInt( 1 );
            String name = rs.getString( "name" );
            double balance = rs.getDouble( 3 );
            
            System.out.println( id + "----" + name + "-----" + balance + "----" );
            //游标向下移动一行
            rs.next();
            int id2 = rs.getInt( 1 );
            String name2 = rs.getString("name" );
            double balance2 = rs.getDouble( 3 );
            System.out.println( id2 + "----" + name2 + "----" + balance2 + "----" );
            
            rs.next();
            int id3 = rs.getInt( 1 );
            String name3 = rs.getString( "name" );
            double balance3 = rs.getDouble( 3 );
            System.out.println( id3 + "----" + name3 + "----" + balance3 + "----" );
            
        }catch( ClassNotFoundException e){
            e.printStackTrace();
        }catch( SQLException e ){
            e.printStackTrace();
        }finally{
            if( rs != null ){
                try{
                    rs.close();
                }catch( SQLException e ){
                    e.printStackTrace();
                }
            }
            
            if( stmt != null ){
                try{
                    stmt.close();
                }catch( SQLException e ){
                    e.printStackTrace();
                }
            }
            
            if( conn != null ){
                try{
                    conn.close();
                }catch( SQLException e ){
                    e.printStackTrace();
                }
            }
            
        }
    }
}
