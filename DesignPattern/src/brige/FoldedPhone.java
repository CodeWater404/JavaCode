package brige;

/**
 * @author ： CodeWater
 * @create ：2022-05-10-16:13
 * @Function Description ：
 */
    //折叠式手机类，继承 抽象类 Ph
public class FoldedPhone extends Phone {
    //构造器
    public FoldedPhone(Brand brand) {
        super(brand);
    }
    public void open() {
        super.open();
        System.out.println(" 折叠样式手机 ");
    }
    public void close() {
        super.close();
        System.out.println(" 折叠样式手机 ");
    }
    public void call() {
        super.call();
        System.out.println(" 折叠样式手机 ");
    }
}
