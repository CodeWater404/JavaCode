package codewater.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-20:34
 * @Function Description ：插件配置类
 */
@Configuration
@MapperScan("codewater.mybatisplus.mapper") //扫描mapper接口(如果有配置类就添加在配置类上，没有就放在主程序入口)
public class MyBatisPlusConfig {
    
    @Bean
    public MybatisPlusInterceptor myBatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //添加分页插件
        interceptor.addInnerInterceptor( new PaginationInnerInterceptor(DbType.MYSQL) );
        //添加乐观锁插件
        interceptor.addInnerInterceptor( new OptimisticLockerInnerInterceptor() );
        return interceptor;
    }
}
