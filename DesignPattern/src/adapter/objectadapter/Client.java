package adapter.objectadapter;

/**
 * @author ： CodeWater
 * @create ：2022-05-09-13:38
 * @Function Description ：
 */
public class Client {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        System.out.println(" === 对象适配器模式 ====");
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter(new Voltage220V()));
    }
}
