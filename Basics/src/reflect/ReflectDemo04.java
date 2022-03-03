package reflect;

import java.lang.reflect.Method;

/**
 * @author ： CodeWater
 * @create ：2022-03-03-15:51
 * @Function Description ：
 * 3. 获取成员方法们：                                                                         
 *             * Method[] getMethods()                                                 
 *             * Method getMethod(String name, 类<?>... parameterTypes)                 
 *
 *             * Method[] getDeclaredMethods()                                         
 *             * Method getDeclaredMethod(String name, 类<?>... parameterTypes)         
 *
 * 4. 获取类名                                                                     
 *             * String getName()                                                      
 */
public class ReflectDemo04 {
    public static void main(String[] args) throws Exception {
        //1.
        Class personClass = Person.class;
        //2.获取无参的方法
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        eat_method.invoke(p);
        
        //3.获取有参的方法
        Method eat_method2 = personClass.getMethod("eat" , String.class);
        //4.执行
        eat_method2.invoke(p , "饭");
        
        System.out.println("===========================");
        
        //5.获取所有（包括继承父类的）
        Method[] methods = personClass.getMethods();
        for(Method method : methods){
            //输出详细的方法名
            System.out.println(method);
//            仅输出方法名
            String name = method.getName();
            System.out.println(name);
            //可以暴力反射
//            method/setAccessible(true);
        }
        
//        获取类名(直接用获取到的类getName)
        String className = personClass.getName();
        System.out.println(className);
    }
    
}
