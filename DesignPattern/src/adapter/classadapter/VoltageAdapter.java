package adapter.classadapter;

/**
 * @author ： CodeWater
 * @create ：2022-05-09-12:27
 * @Function Description ：适配器
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
// TODO Auto-generated method stub
//获取到 220V 电压
        int srcV = output220V();
        int dstV = srcV / 44 ; //转成 5v
        return dstV;
    }
}
