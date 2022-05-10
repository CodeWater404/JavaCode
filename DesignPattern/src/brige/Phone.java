package brige;

/**
 * @author ： CodeWater
 * @create ：2022-05-10-16:13
 * @Function Description ：
 */
public abstract class Phone {
    //组合品牌
    private Brand brand;
    //构造器
    public Phone(Brand brand) {
        super();
        this.brand = brand;
    }
    protected void open() {
        this.brand.open();
    }
    protected void close() {
        brand.close();
    }
    protected void call() {
        brand.call();
    }
}
