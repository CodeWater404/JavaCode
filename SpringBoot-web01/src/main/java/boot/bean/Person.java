package boot.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author ： CodeWater
 * @create ：2022-04-27-22:17
 * @Function Description ：
 */
@Data//使用这个注解可以省去实体类中大量的get()、 set()、 toString()等方法。
public class Person {
    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;
}
