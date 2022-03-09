package jdbc.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author ： CodeWater
 * @create ：2022-03-09-11:03
 * @Function Description ：jdbc工具类
 */
public class JDBCUtils {
    private static String url ;
    private static String user;
    private static String password;
    private static String driver;
    
/*文件的读取，只需要读取一次即可拿到这些值，所以使用静态代码块*/
    static{
        try{
            Properties pro = new Properties();
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties" );
            String path = res.getPath();
            //加载文件
            pro.load( new FileReader( path) );
            
            //获取数据、赋值
            url = pro.getProperty( "url" );
            user = pro.getProperty( "user" );
            password = pro.getProperty( "password" );
            driver = pro.getProperty( "driver" );
            Class.forName( driver );
            
        }catch( IOException e ) {
            e.printStackTrace();
        }catch( ClassNotFoundException e ){
            e.printStackTrace();
        }
    }
    
    /*获取连接
    * */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url , user , password );
    }

    /*释放资源*/
    public static void close( Statement stmt , Connection conn ){
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
    
    /*释放资源，多个ResultSet
    * */
    public static void close(ResultSet rs , Statement stmt , Connection conn ){
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
