package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author ： CodeWater
 * @create ：2022-06-03-23:23
 * @Function Description ：
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Book {
    private Long id;
    private String name;
    private String category;  //分类
    private Integer score;
    //简介
    private String intro;
}
