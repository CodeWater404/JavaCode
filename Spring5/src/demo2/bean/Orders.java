package demo2.bean;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-23:51
 * @Function Description ：
 * 演示bean的生命周期执行顺序
 */
public class Orders {
    public Orders() {
        System.out.println("第一步，无参执行");
    }

    private String oname;

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步，调用set方法");

    }

    public void initMethod() {
        System.out.println("第三步执行初始化的方法");
    }

    public void destoryMethod() {
        System.out.println("第五步 执行销毁的方法");
    }
}
