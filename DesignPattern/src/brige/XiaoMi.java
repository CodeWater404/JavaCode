package brige;

/**
 * @author ： CodeWater
 * @create ：2022-05-10-16:15
 * @Function Description ：
 */
public class XiaoMi implements Brand {
    @Override
    public void open() {
        System.out.println(" 小米手机开机 ");
    }

    @Override
    public void close() {
// TODO Auto-generated method stub
        System.out.println(" 小米手机关机 ");
    }

    @Override
    public void call() {
// TODO Auto-generated method stub
        System.out.println(" 小米手机打电话 ");
    }

}
