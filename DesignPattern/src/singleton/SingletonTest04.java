package singleton;

/**
 * @author ： CodeWater
 * @create ：2022-05-05-15:53
 * @Function Description ：单例模式（懒汉式，线程安全）
 */
public class SingletonTest04 {
    public static void main(String[] args) {
        System.out.println("懒汉式 2 ， 线程安全~");
        Singleton4 instance = Singleton4.getInstance();
        Singleton4 instance2 = Singleton4.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode())
    }
    
}

// 懒汉式(线程安全，同步方法)
class Singleton4 {
    private static Singleton4 instance;
    private Singleton4() {}
    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
//即懒汉式
    public static synchronized Singleton4 getInstance() {
        if(instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}

