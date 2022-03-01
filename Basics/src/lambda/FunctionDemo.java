package lambda;

import java.util.function.Function;

/**
 * @author ： CodeWater
 * @create ：2022-03-01-18:12
 * @Function Description ：java.util.function.Function<T,R> 接口用来根据一个类型的数据得到另一个类型的数据，
 * 
 * Function 接口中最主要的抽象方法为： R apply(T t) ，根据类型T的参数获取类型R的结果。
 * 使用的场景例如：将 String 类型转换为 Integer 类型。
 */
public class FunctionDemo {
    private static void method(Function<String,Integer> function){
        //apply方法由调用时候的lambda具体实现了
        int num = function.apply("10");
        
        System.out.println(num + 20 );
    }
    
    public static void main(String[] args){
        method(s -> Integer.parseInt(s) );
    }
}
