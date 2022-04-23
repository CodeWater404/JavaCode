package demo2.autowire;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-0:16
 * @Function Description ：
 */
public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;

    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }

    public void test() {
        System.out.println(dept);
    }

}
