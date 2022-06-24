package proxy.staticproxy;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-0:25
 * @Function Description ：
 * 被代理的对象，也就是目标对象
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
// TODO Auto-generated method stub
        System.out.println(" 老师授课中 。。。。。");
    }
}
