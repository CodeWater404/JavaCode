package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-06-03-23:21
 * @Function Description ：
 */

@Data
@AllArgsConstructor  //全部参数的构造函数的自动生成
@NoArgsConstructor  //无参构造函数
@EqualsAndHashCode //用于后期的去重使用
public class Author {
    private Long id;
    private String name;
    private Integer age;
    private String intro;//简介
    private List<Book> books;
}
