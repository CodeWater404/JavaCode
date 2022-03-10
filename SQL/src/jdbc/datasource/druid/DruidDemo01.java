package jdbc.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author ： CodeWater
 * @create ：2022-03-10-15:45
 * @Function Description ：
 * Druid演示
 */
public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
        Properties pro = new Properties();
        InputStream is = DruidDemo01.class.getClassLoader().getResourceAsStream( "druid.properties" );
        pro.load( is );
        
        DataSource ds = DruidDataSourceFactory.createDataSource( pro );
        Connection conn = ds.getConnection();
        System.out.println( conn );
    }
}
