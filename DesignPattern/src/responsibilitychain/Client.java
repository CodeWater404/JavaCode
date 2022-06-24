package responsibilitychain;

/**
 * @author ： CodeWater
 * @create ：2022-06-24-23:32
 * @Function Description ：职责链模式处理
 *  采购员采购教学器材 
 * 如果金额 小于等于 5000, 由教学主任审批 
 * 如果金额 小于等于 10000, 由院长审批 
 * 如果金额 小于等于 30000, 由副校长审批 
 * 如果金额 超过 30000，有校长审批
 */
public class Client {
    public static void main(String[] args) {
// TODO Auto-generated method stub
//创建一个请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 31000, 1);
//创建相关的审批人
        DepartmentApprover departmentApprover = new DepartmentApprover("张主任");
        CollegeApprover collegeApprover = new CollegeApprover("李院长");
        ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("王副校");
        SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("佟校长");
//================需要将各个审批级别的下一个设置好 (处理人构成环形: )==============
        /**
         * Approver抽象父类中就定义了一个Approver，而这个Approver的意思是下一个能处理的类！！！
         * 所以实际上类里面的processRequest方法是由下一个类来处理（处理不了的情况），而不是本类！！！！
         */
        departmentApprover.setApprover(collegeApprover);
        collegeApprover.setApprover(viceSchoolMasterApprover);
        viceSchoolMasterApprover.setApprover(schoolMasterApprover);
        schoolMasterApprover.setApprover(departmentApprover);
        
        
        departmentApprover.processRequest(purchaseRequest);
        viceSchoolMasterApprover.processRequest(purchaseRequest);
    }
}
