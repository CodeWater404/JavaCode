package codewater.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-22:23
 * @Function Description ：
 */
@Getter
public enum SexEnum {
    
    MALE( 1  , "男" ),
    FEMALE( 2 , "女" );

    @EnumValue //将注解所标识的属性的值 存储到数据库中（这里配置后，还需要在yml文件中配置）
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
    
}
