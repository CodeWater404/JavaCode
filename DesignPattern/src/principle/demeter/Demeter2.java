package principle.demeter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-05-03-17:18
 * @Function Description ：
 * 改进：
 * 前面设计的问题在于 SchoolManager 中，CollegeEmployee 类并不是 SchoolManager 类的直接朋友 (分析)
 * 按照迪米特法则，应该避免类中出现这样非直接朋友关系的耦合
 */
public class Demeter2 {
    public static void main(String[] args) {
        System.out.println("~~~使用迪米特法则的改进~~~");
//创建了一个 SchoolManager 对象
        SchoolManager2 schoolManager = new SchoolManager2();
//输出学院的员工 id 和 学校总部的员工信息
        schoolManager.printAllEmployee(new CollegeManager2());
    }
}

//学校总部员工类
class Employee2 {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

//学院的员工类
class CollegeEmployee2 {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

//管理学院员工的管理类
class CollegeManager2 {
    //返回学院的所有员工
    public List<CollegeEmployee2> getAllEmployee() {
        List<CollegeEmployee2> list = new ArrayList<CollegeEmployee2>();
        for (int i = 0; i < 10; i++) { //这里我们增加了 10 个员工到 list
            CollegeEmployee2 emp = new CollegeEmployee2();
            emp.setId("学院员工 id= " + i);
            list.add(emp);
        }
        return list;
    }

    //输出学院员工的信息=======================增加
    public void printEmployee() {
//获取到学院员工
        List<CollegeEmployee2> list1 = getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee2 e : list1) {
            System.out.println(e.getId());
        }
    }
}

//学校管理类
//分析 SchoolManager 类的直接朋友类有哪些 Employee、CollegeManager
//CollegeEmployee 不是 直接朋友 而是一个陌生类，这样违背了 迪米特法则
class SchoolManager2 {
    //返回学校总部的员工
    public List<Employee2> getAllEmployee() {
        List<Employee2> list = new ArrayList<Employee2>();
        for (int i = 0; i < 5; i++) { //这里我们增加了 5 个员工到 list
            Employee2 emp = new Employee2();
            emp.setId("学校总部员工 id= " + i);
            list.add(emp);
        }
        return list;
    }

    //该方法完成输出学校总部和学院员工信息(id)
    void printAllEmployee(CollegeManager2 sub) {
//分析问题
//1. 将输出学院的员工方法，封装到 CollegeManager==================这接调佣打印，就不用定成一个变量的collegeEmployee
        sub.printEmployee();
//获取到学校总部员工
        List<Employee2> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee2 e : list2) {
            System.out.println(e.getId());
        }
    }
}
