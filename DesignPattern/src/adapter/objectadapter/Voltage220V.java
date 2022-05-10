package adapter.objectadapter;

/**
 * @author ： CodeWater
 * @create ：2022-05-09-13:40
 * @Function Description ：
 */
public class Voltage220V {
    //输出 220V 的电压，不变
    public int output220V() {
        int src = 220;
        System.out.println("电压=" + src + "伏");
        return src;
    }
}
