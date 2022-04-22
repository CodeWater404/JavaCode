package boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ： CodeWater
 * @create ：2022-04-21-17:31
 * @Function Description ：
 */
@NoArgsConstructor//空参构造
@AllArgsConstructor//有参构造
@ToString
@Data
public class Pet {
    private String name;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return "Pet{" +
//                "name='" + name + '\'' +
//                '}';
//    }
//
//    public Pet(String name) {
//        this.name = name;
//    }
//
//    public Pet() {
//    }
}
