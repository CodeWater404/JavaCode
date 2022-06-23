package singleton;

/**
 * @author ： CodeWater
 * @create ：2022-05-06-13:25
 * @Function Description ：单例模式（静态内部类）
 */
public class SingletonTest07 {
    public static void main(String[] args) {
        System.out.println("使用静态内部类完成单例模式");
        Singleton7 instance = Singleton7.getInstance();
        Singleton7 instance2 = Singleton7.getInstance();
        System.out.println(instance == instance2); // true
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}

// 静态内部类完成， 推荐使用
class Singleton7 {

    //构造器私有化
    private Singleton7() {
    }

    //写一个静态内部类,该类中有一个静态属性 Singleton7
    private static class Singleton7Instance {
        //                //不会在singleton7构造的时候执行，而是当调佣这个类的时候在执行（懒加载
//       第一次调用的时候，instance没有初始化所以才会走到new创建；第二次再调用的时候，因为对于这个类来说已经有了，所以不会
//       走到这里创建，直接在getInstance那里返回了！！！！
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    //提供一个静态的公有方法，直接返回 Singleton7Instance.INSTANCE============================
    public static synchronized Singleton7 getInstance() {
        return Singleton7Instance.INSTANCE;
    }
}

