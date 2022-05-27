package adapter.classadapter;

/**
 * @author ： CodeWater
 * @create ：2022-05-09-12:25
 * @Function Description ：类适配器
 */
public class Client {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        System.out.println(" === 类适配器模式 ====");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }

}
