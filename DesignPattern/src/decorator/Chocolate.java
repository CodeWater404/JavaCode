package decorator;

/**
 * @author ： CodeWater
 * @create ：2022-05-13-15:26
 * @Function Description ：
 * 具体的 Decorator， 这里就是调味品
 */

public class Chocolate extends Decorator {
    public Chocolate(Drink obj) {
        super(obj);
        setDes(" 巧克力 ");
        setPrice(3.0f); // 调味品 的价格
    }
}
