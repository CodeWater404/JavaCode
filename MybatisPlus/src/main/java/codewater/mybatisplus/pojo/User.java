package codewater.mybatisplus.pojo;

import codewater.mybatisplus.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-0:46
 * @Function Description ：实体类
 */
@Data //代替下面的所有注解
//@NoArgsConstructor //提供无参构造方法
//@AllArgsConstructor //有参
//@EqualsAndHashCode  //重写equals和hashcode方法
//@Getter
//@Setter
//@TableName("t_user")   //设置实体类对应的数据库中的表名
public class User {
    
    //@TableId //把这个属性对应的字段作为主键，
    // @TableId（vlaue = “” , type = ）中的value属性表示指定主键的字段;type设置主键生成策略
    private Long id; // 如果不设置id的值，框架会默认采用雪花算法赋值
    
    //@TableField("user_name")  //指定属性对应的字段名
    private String name;
    
    private Integer age ;
    
    private String email;
    
    private SexEnum sex;
    
    @TableLogic
    private Integer isDeteled; //默认是开启下划线转驼峰的
    
}
