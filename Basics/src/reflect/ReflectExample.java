package reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author ： CodeWater
 * @create ：2022-03-03-17:01
 * @Function Description ：reflect案例
 * 不能改变该类的任何代码。可以创建任意类的对象，可以执行任意方法
 */
public class ReflectExample {
    public static void main(String[] args) throws Exception {
        //    1.加载配置文件
        Properties pro = new Properties();
        //2.加载配置文件转换为一个集合；获取class目录下的配置文件
        ClassLoader classLoader = ReflectExample.class.getClassLoader();
        //这里配置文件在src目录下的话直接写文件名即可；如不在需要从src路径开始写起
        InputStream is = classLoader.getResourceAsStream("./reflect/pro.properties");
        pro.load(is);//加载
        
        //3.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        
        //4.加载该类（配置文件中指定的类）进内存
        Class cls = Class.forName(className);
        //5.创建对象
        Object obj = cls.newInstance();
        //6.获取方法对象
        Method method = cls.getMethod(methodName);
        //7.执行方法，传入对应的对象
        method.invoke(obj);
                
    }
}
