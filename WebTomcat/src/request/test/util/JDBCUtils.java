package request.test.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-12:14
 * @Function Description ：
 * JDBC工具类，使用druid连接池
 */
public class JDBCUtils {
    private static DataSource ds ;
    static{
        try{
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream( "druid.properties" );
            pro.load( is );
            //初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(  pro );
            
        }catch( IOException e ){
            e.printStackTrace();
        }catch( Exception e ){
            e.printStackTrace();
        }
    }
    
    public static DataSource getDataSource(){
        return ds ;
    }
    
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    
}
