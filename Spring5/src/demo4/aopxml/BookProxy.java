package demo4.aopxml;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-22:45
 * @Function Description ：
 * 增强类，但是使用xml来进行，具体看bean2
 */
public class BookProxy {
    public void before(){
        System.out.println( "before...." );
    }
}
