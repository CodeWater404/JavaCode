package strategy;

/**
 * @author ： CodeWater
 * @create ：2022-06-24-17:31
 * @Function Description ：
 */
public abstract class Duck {
    public Duck() {
    }
    public abstract void display();//显示鸭子信息
    public void quack() {
        System.out.println("鸭子嘎嘎叫~~");
    }
    public void swim() {
        System.out.println("鸭子会游泳~~");
    }
    public void fly() {
        System.out.println("鸭子会飞翔~~~");
    }
}
