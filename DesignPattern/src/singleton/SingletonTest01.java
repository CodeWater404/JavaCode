package singleton;

/**
 * @author ： CodeWater
 * @create ：2022-05-05-15:24
 * @Function Description ：单例模式（静态常量）
 */
public class SingletonTest01 {
    public static void main(String[] args) {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
//        判断是不是同一个对象
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
    
}


//饿汉式(静态变量)
class Singleton {
    //1. 构造器私有化, 防止外部能 new
    private Singleton() { }
    //2.本类内部创建对象实例
    private final static Singleton instance = new Singleton();
    
    //3. 提供一个公有的静态方法，返回实例对象=======================
    public static Singleton getInstance() {
        return instance;
    }
}