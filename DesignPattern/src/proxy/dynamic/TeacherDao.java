package proxy.dynamic;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-0:42
 * @Function Description ：
 * 目标对象，也就是被代理的对象
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
// TODO Auto-generated method stub
        System.out.println(" 老师授课中.... ");
    }
    @Override
    public void sayHello(String name , int i ) {
// TODO Auto-generated method stub
        System.out.println("hello " + name );
        System.out.println("i: " + i);
    }
}
