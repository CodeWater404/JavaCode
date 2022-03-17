package jspCase.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author ： CodeWater
 * @create ：2022-03-17-15:05
 * @Function Description ：
 * jdbc工具类，druid连接池
 */
public class JDBCUtils {
    private static DataSource ds ;
    
    static{
        try{
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream( "jspCase/druid.properties" );
            
            pro.load( is );
            
            ds = DruidDataSourceFactory.createDataSource( pro );
        }catch( IOException e ){
            e.printStackTrace();
        }catch( Exception e ){
            e.printStackTrace();
        }
    }
    
//    获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
    
//    获取连接池对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
