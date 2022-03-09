package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

/**
 * @author ： CodeWater
 * @create ：2022-03-09-10:48
 * @Function Description ：执行DQL查询语句（改用while处理if）
 */
public class JdbcDemo07 {
    public static void main( String[] args ){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection( "jdbc:mysql:///db3" ,"root" , "root" );
            String sql = " select * from account ";
            stmt = conn.createStatement();
            rs = stmt.executeQuery( sql );
            while( rs.next() ){
                int id = rs.getInt( 1 );
                String name = rs.getString( "name" );
                //获取这一行的第三列
                double balance = rs.getDouble( 3 );
                System.out.println( id + "---" + name + "---" + balance + "---" );
            }
 
        }catch( ClassNotFoundException e ){
            e.printStackTrace();
        }catch( SQLException e ){
            e.printStackTrace();
        }finally{
            if( rs != null ){
                try{
                    rs.close();
                }catch(SQLException e ){
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
