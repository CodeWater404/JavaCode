package demo6.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author ： CodeWater
 * @create ：2022-04-06-23:13
 * @Function Description ：
 * 完全注解开发的配置类
 */
@Configuration
@ComponentScan( basePackages="demo6")
@EnableTransactionManagement //开启事务
public class TxConfig {
    @Bean
    public DruidDataSource getDruidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///user_db");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }
    
    @Bean//这种是传参的；另外一种是set那里直接写dataSource的函数；不过建议用传参的
    public JdbcTemplate  getJdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource( dataSource );
        return jdbcTemplate;
    }
    
    @Bean//创建事务管理器
    public DataSourceTransactionManager getDataSourceTransactionManager( DataSource dataSource ){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource( dataSource );
        return transactionManager;
    } 
    
}
