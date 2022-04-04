package demo1.bean;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-21:45
 * @Function Description ：
 * 员工类
 */
public class Emp {
    private String ename;
    private String gender ;
//    员工属于某一部门，用对象形式
    private Dept dept ;

//    这个在这些是因为xml里面赋值的时候要获取才能赋值
    public Dept getDept(){
        return dept;
    }
    
    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
    
    public void add(){
        System.out.println( ename + ":" + gender + ":" + dept );
    }
}
