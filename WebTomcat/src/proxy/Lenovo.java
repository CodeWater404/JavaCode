package proxy;

/**
 * @author ： CodeWater
 * @create ：2022-03-19-11:06
 * @Function Description ：
 * 真实类，实现买电脑的接口
 */
public class Lenovo implements SaleComputer{
    public String sale( double money ){
        System.out.println( "花了" + money + "元买了一台电脑。。。。" );
        return "电脑";
    }
    
    public void show(){
        System.out.println( "展示电脑。。。。。" );
    }
}
