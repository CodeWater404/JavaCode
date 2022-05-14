package composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-05-14-14:11
 * @Function Description ：
 * University 就是 Composite , 可以管理 College
 */
public class University extends OrganizationComponent {
    //抽象父类放在子类中，组合在一起
    List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();
    
    // 构造器
    public University(String name, String des) {
        super(name, des);
// TODO Auto-generated constructor stub
    }
    
    // 重写 add
    @Override
    protected void add(OrganizationComponent organizationComponent) {
// TODO Auto-generated method stub
        organizationComponents.add(organizationComponent);
    }
    
    // 重写 remove
    @Override
    protected void remove(OrganizationComponent organizationComponent) {
// TODO Auto-generated method stub
        organizationComponents.remove(organizationComponent);
    }
    
    @Override
    public String getName() {
// TODO Auto-generated method stub
        return super.getName();
    }
    
    @Override
    public String getDes() {
// TODO Auto-generated method stub
        return super.getDes();
    }
    
    // print 方法，就是输出 University 包含的学院
    @Override
    protected void print() {
// TODO Auto-generated method stub
        System.out.println("--------------" + getName() + "--------------");
//遍历 organizationComponents
        for (OrganizationComponent organizationComponent : organizationComponents) {
            organizationComponent.print();
        }
    }
    
}
