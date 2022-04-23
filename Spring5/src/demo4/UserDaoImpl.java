package demo4;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-20:50
 * @Function Description ：
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行了。。。。。");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("update方法执行了");
        return id;
    }
}
