package decorator;

/**
 * @author ： CodeWater
 * @create ：2022-05-13-15:32
 * @Function Description ：
 */
public class Milk extends Decorator {
    public Milk(Drink obj) {
        super(obj);
// TODO Auto-generated constructor stub
        setDes(" 牛奶 ");
        setPrice(2.0f);
    }


}
