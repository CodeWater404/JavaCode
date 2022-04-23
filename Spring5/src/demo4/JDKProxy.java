package demo4;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-20:49
 * @Function Description ：
 * 有接口的动态代理，基于jdk的
 */
public class JDKProxy {
    public static void main(String[] args) throws IOException {
        //    创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
//        
//        Proxy.newProxyInstance( JDKProxy.class.getClassLoader() , interfaces , new InvocationHandler(){
//            @Override
//            public Object invoke( Object proxy , Method method , Object[] args ) throws Throwable{
//                return null;
//            }
//        } );
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int result = dao.add(1, 2);
        System.out.println("result:" + result);
//        另外一种

    }


}


//代理对象
class UserDaoProxy implements InvocationHandler {
    //1 把创建的是谁的代理对象，把谁传递过来
    //有参数构造传递
    private Object obj;

    public UserDaoProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法之前" + "传递的参数：" + Arrays.toString(args));
        Object res = method.invoke(obj, args);
        System.out.println("方法之后");
        return res;
    }

}
