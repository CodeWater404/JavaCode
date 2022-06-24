package strategy;

/**
 * @author ： CodeWater
 * @create ：2022-06-24-17:31
 * @Function Description ：
 */
public class PekingDuck extends Duck {
    @Override
    public void display() {
// TODO Auto-generated method stub
        System.out.println("~~北京鸭~~~");
    }
    //因为北京鸭不能飞翔，因此需要重写 fly
    @Override
    public void fly() {
// TODO Auto-generated method stub
        System.out.println("北京鸭不能飞翔");
    }
}
