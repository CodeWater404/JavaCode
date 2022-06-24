package strategy.improve;

/**
 * @author ： CodeWater
 * @create ：2022-06-24-17:46
 * @Function Description ：
 */
public class WildDuck extends Duck {
    //构造器，传入 FlyBehavor 的对象
    public WildDuck() {
// TODO Auto-generated constructor stub
        flyBehavior = new GoodFlyBehavior();
    }
    @Override
    public void display() {
// TODO Auto-generated method stub
        System.out.println(" 这是野鸭 ");
    }
}
