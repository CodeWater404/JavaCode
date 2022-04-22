package boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ： CodeWater
 * @create ：2022-04-22-16:38
 * @Function Description ：
 * 
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 * 
 */
@Component
//@ConfigurationProperties(prefix="mycar")//把javaBean跟核心配置文件中的绑定
//    再和配置文件中的
//    EnableConfiguraationProperties注解配合
@ConfigurationProperties(prefix="mycar")//把javaBean跟配置文件中的绑定
@ToString//生成toString方法
@Data//生成setget方法
public class Car {
//    @Override
//    public String toString() {
//        return "Car{" +
//                "brand='" + brand + '\'' +
//                ", price=" + price +
//                '}';
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//    public String getBrand(){
//        return brand;
//
//    }
    private String brand;
    private Integer price;
    
    

    
    
}
