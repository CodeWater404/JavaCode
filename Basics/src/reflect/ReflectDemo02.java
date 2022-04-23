package reflect;

import java.lang.reflect.Field;

/**
 * @author ： CodeWater
 * @create ：2022-03-03-13:44
 * @Function Description ：含有declared的，连私有都能获取
 * Class对象功能：
 * * 获取功能：
 * 1. 获取成员变量们
 * * Field[] getFields()
 * * Field getField(String name)
 * <p>
 * * Field[] getDeclaredFields()
 * * Field getDeclaredField(String name)
 */
public class ReflectDemo02 {
    public static void main(String[] args) throws Exception {
        Class personClass = Person.class;
        //1.获取成员变量，只有public可以
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        //2.get member variable a 
        Field a = personClass.getField("a");
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        //set a
        a.set(p, "张三");
        System.out.println(p);

        System.out.println("=====================");
        //获取成员变量，不考虑修饰符
        Field[] declaredFidles = personClass.getDeclaredFields();
        for (Field declaredField : declaredFidles) {
            System.out.println(declaredField);
        }

        System.out.println("==============");
        //获取单个
        Field d = personClass.getDeclaredField("d");
        //忽视访问权限
        d.setAccessible(true);
        //p是Person，前面定义了
        Object value2 = d.get(p);
        System.out.println(value2);
    }
}
