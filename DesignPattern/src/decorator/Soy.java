package decorator;

/**
 * @author ： CodeWater
 * @create ：2022-05-13-15:34
 * @Function Description ：
 */
public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
// TODO Auto-generated constructor stub
        setDes(" 豆浆 ");
        setPrice(1.5f);
    }
    
}
