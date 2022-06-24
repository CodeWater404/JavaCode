package responsibilitychain;

/**
 * @author ： CodeWater
 * @create ：2022-06-24-23:33
 * @Function Description ：院长
 */
public class CollegeApprover extends Approver {
    public CollegeApprover(String name) {
// TODO Auto-generated constructor stub
        super(name);
    }

    /**
     * 处理请求
     * @param purchaseRequest
     */
    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
// TODO Auto-generated method stub
        if(purchaseRequest.getPrice() < 5000 && purchaseRequest.getPrice() <= 10000) {
            System.out.println(" 请求编号 id= " + purchaseRequest.getId() + " 被 " + this.name + " 处理");
        }else {
            //超出处理范围，由下个接收
            approver.processRequest(purchaseRequest);
        }
    }
}
