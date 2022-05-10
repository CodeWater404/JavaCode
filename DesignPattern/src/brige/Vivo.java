package brige;

/**
 * @author ： CodeWater
 * @create ：2022-05-10-16:14
 * @Function Description ：
 */
public class Vivo implements Brand {
    @Override
    public void open() {
// TODO Auto-generated method stub
        System.out.println(" Vivo 手机开机 ");
    }
    @Override
    public void close() {
// TODO Auto-generated method stub
        System.out.println(" Vivo 手机关机 ");
    }
    @Override
    public void call() {
// TODO Auto-generated method stub
        System.out.println(" Vivo 手机打电话 ");
    }
}
