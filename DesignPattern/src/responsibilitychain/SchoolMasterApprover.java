package responsibilitychain;

/**
 * @author ： CodeWater
 * @create ：2022-06-24-23:35
 * @Function Description ：校长
 */
public class SchoolMasterApprover extends Approver {
    public SchoolMasterApprover(String name) {
// TODO Auto-generated constructor stub
        super(name);
    }
    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
// TODO Auto-generated method stub
        if(purchaseRequest.getPrice() > 30000) {
            System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
        }else {
            approver.processRequest(purchaseRequest);
        }
    }
}
