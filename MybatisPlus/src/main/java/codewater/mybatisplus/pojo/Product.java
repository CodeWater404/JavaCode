package codewater.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-21:46
 * @Function Description ：
 */
@Data
public class Product {
    
    private Long id;
    
    private String name ;
    
    private Integer price;
    
    @Version //表示乐观锁版本号字段
    private Integer version;
    
}
