package demo1;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-19:57
 * @Function Description ：
 * 演示有参构造注入
 */
public class Order {
    private String oname ="";
    private String address;
    
    public Order( String oname , String address ){
        this.oname = oname;
        this.address = address;
    }
    
    public void ordersTest(){
        System.out.println( oname + "::" + address );
    }
}
