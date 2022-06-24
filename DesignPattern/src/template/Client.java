package template;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-1:51
 * @Function Description ：
 */
public class Client {
    
    public static void main(String[] args) {
// TODO Auto-generated method stub
//制作红豆豆浆
        System.out.println("----制作红豆豆浆----");
        SoyaMilk redBeanSoyaMilk = new RedBeanSoyaMilk();
        redBeanSoyaMilk.make();
        
        System.out.println("----制作花生豆浆----");
        SoyaMilk peanutSoyaMilk = new PeanutSoyaMilk();
        peanutSoyaMilk.make();
        
//        这里使用了钩子函数，制作了没有调味剂的豆浆。并且上面的方法依然能够正确执行有调味剂的
        System.out.println("----制作纯豆浆----");
        SoyaMilk pureSoyaMilk = new PureSoyaMilk();
        pureSoyaMilk.make();
    }
    
}
