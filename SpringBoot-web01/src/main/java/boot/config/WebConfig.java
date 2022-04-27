package boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author ： CodeWater
 * @create ：2022-04-25-20:42
 * @Function Description ：
 * 自定义web相关的配置
 */
@Configuration(proxyBeanMethods =  false )
public class WebConfig /*implements WebMvcConfigurer*/ {
//    自定义表单中的name属性值_method，可以把方法改为put的
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("_m");
        return methodFilter;
    }
    
//    开启矩阵变量，方法一：实现接口WebMvcConfigurer
//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer ){
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        // 不移除；后面的内容。矩阵变量功能就可以生效
//        urlPathHelper.setRemoveSemicolonContent( false );
//        configurer.setUrlPathHelper( urlPathHelper );
//    }
    
//    方法二：
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
          @Override
          public void configurePathMatch( PathMatchConfigurer configurer ){
              UrlPathHelper urlPathHelper = new UrlPathHelper();
              // 不移除；后面的内容。矩阵变量功能就可以生效
              urlPathHelper.setRemoveSemicolonContent( false );
              configurer.setUrlPathHelper( urlPathHelper );
          }  
        };
    }
}
