package adapter.classadapter;

/**
 * @author ： CodeWater
 * @create ：2022-05-09-12:26
 * @Function Description ：
 */
public class Phone {
    public void charging(IVoltage5V iVoltage5V) {
        if(iVoltage5V.output5V() == 5) {
            System.out.println("电压为 5V, 可以充电~~");
        } else if (iVoltage5V.output5V() > 5) {
            System.out.println("电压大于 5V, 不能充电~~");
        }
    }
    
}
