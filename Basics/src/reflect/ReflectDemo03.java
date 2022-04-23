package reflect;

import java.lang.reflect.Constructor;

/**
 * @author ： CodeWater
 * @create ：2022-03-03-14:07
 * @Function Description ：
 * 2. 获取构造方法们
 * Constructor<?>[] getConstructors()
 * Constructor<T> getConstructor(类<?>... parameterTypes)
 * <p>
 * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
 * Constructor<?>[] getDeclaredConstructors()
 */
public class ReflectDemo03 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        //获取构造方法
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);

        //创建对象
        Object person = constructor.newInstance("张三", 32);
        System.out.println(person);

        System.out.println("==================");

        //获取空参构造
        Constructor constructor1 = personClass.getConstructor();
        System.out.println(constructor1);
//        创建对象     (用构造)
        Object person1 = constructor1.newInstance();
        System.out.println(person1);
//         创建对象（用class的方法
        Object o = personClass.newInstance();
        System.out.println(o);

        //也有构造的安全检查constructor1.setAccessible(true;
    }
}
