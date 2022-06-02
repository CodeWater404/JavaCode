package codewater.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-23:09
 * @Function Description ：
 */
@Data
@TableName("t_user")
public class User {

    @TableId  //设置成主键.属性和字段不一致时需要用上！！
    private Long id; // 如果不设置id的值，框架会默认采用雪花算法赋值

    //@TableField("user_name")  //指定属性对应的字段名
    private String name;

    private Integer age ;

    private String email;

    private Integer sex;
    
    private Integer isDeteled; //默认是开启下划线转驼峰的
}
