package singleton;

/**
 * @author ： CodeWater
 * @create ：2022-05-06-15:06
 * @Function Description ：单例模式（枚举）
 */
public class SingletonTest08 {
    public static void main(String[] args) {
        Singleton8 instance = Singleton8.INSTANCE;
        Singleton8 instance2 = Singleton8.INSTANCE;
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
        instance.sayOK();
    }
}


///使用枚举，可以实现单例, 推荐
enum Singleton8 {
    INSTANCE; //属性
    public void sayOK() {
        System.out.println("ok~");
    }

}