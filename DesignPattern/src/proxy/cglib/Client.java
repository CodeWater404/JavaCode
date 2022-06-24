package proxy.cglib;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-1:10
 * @Function Description ：
 */
public class Client {
    
    public static void main(String[] args) {
// TODO Auto-generated method stub
//创建目标对象
        TeacherDao target = new TeacherDao();
//============获取到代理对象，并且将目标对象传递给代理对象==================
        TeacherDao proxyInstance = (TeacherDao)new ProxyFactory(target).getProxyInstance();
        
//执行代理对象的方法，触发 intecept 方法，从而实现 对目标对象的调用
        String res = proxyInstance.teach();
        System.out.println("res=" + res);
        
        //==========================调用方法这里才指定要代理的具体方法============================
//        String te = proxyInstance.te();
//        System.out.println(te);
    }
    
}
