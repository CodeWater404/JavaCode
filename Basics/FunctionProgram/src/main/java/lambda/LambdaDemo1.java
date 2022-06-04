package lambda;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/**
 * @author ： CodeWater
 * @create ：2022-06-03-23:04
 * @Function Description ：训练lambda表达式
 * 秘诀： 主要看参数接口里面有那个方法，这个接口的方法有没有参数； 然后就是这个接口方法的实现逻辑
 * 
 * 省略规则：
 *      1. 参数类型可以省略
 *      2. 方法体只有一句代码是打括号return和唯一一句代码的分号可以省略
 *      3. 方法只有一个参数是小括号可以省略
 *      
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        //lambda
//        foreachArr( v ->{
//            System.out.println( v );
//        });
        
        //函数是接口常用默认方法and
        printNum2( value -> value % 2 == 0 , value -> value > 4 );
    }

    public static void printNum2 (IntPredicate intPredicate1 , IntPredicate intPredicate2 ){
        int[] arr = { 1 , 2, 3, 4 , 5, 6, 7 , 8, 9 , 10 };
        for( int i : arr ){
            //符合条件，打印出i
            if( intPredicate1.and(intPredicate2).test(i) ){
                System.out.println( i );
            }
        }
    }
    
    public static void foreachArr(IntConsumer intConsumer ){
        int[] arr = { 1 , 2, 3, 4 , 5, 6, 7 , 8, 9 , 10 };
        for( int i : arr ){
            intConsumer.accept( i );
        }
    }
}
