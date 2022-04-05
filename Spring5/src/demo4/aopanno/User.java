package demo4.aopanno;

import org.springframework.stereotype.Component;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-21:50
 * @Function Description ：
 * 被增强的类
 */
@Component
public class User {
    public void add(){
//        int i = 10 /0;
//        
        System.out.println( "add........." );
    }
}
