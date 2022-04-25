package boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

/**
 * @author ： CodeWater
 * @create ：2022-04-25-20:42
 * @Function Description ：
 * 自定义web相关的配置
 */
@Configuration
public class WebConfig {
//    自定义表单中的name属性值_method，可以把方法改为put的
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }
    
    
}
