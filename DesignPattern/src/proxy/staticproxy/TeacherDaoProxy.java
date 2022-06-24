package proxy.staticproxy;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-0:26
 * @Function Description ：
 * 代理对象,静态代理
 */
public class TeacherDaoProxy implements ITeacherDao {
    private ITeacherDao target; // 目标对象，通过接口来聚合=====
    //构造器=============构造的是要被代理的对象！！！！
    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }
    
    @Override
    public void teach() {
// TODO Auto-generated method stub
        System.out.println("开始代理 完成某些操作。。。。。 ");//方法
        /**
         * target是接口，但其实这里用的是目标对象（被代理的）的具体实现方法
         */
        target.teach();
        System.out.println("提交。。。。。");//方法
    }
}
