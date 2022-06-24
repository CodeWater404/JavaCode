package proxy.cglib;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-1:12
 * @Function Description ：
 * 目标对象（被代理的）
 */
public class TeacherDao {
    public String teach() {
        System.out.println(" 老师授课中 ， 我是 cglib 代理，不需要实现接口 ");
        return "hello";
    }
    
    public String te(){
        System.out.println("fdhsjkfhsdkgdg");
        return "fdhsjkfhsdkgdg";
    }
}
