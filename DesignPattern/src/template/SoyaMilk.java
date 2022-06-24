package template;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-1:53
 * @Function Description ：
 * 抽象类，表示豆浆
 */
public abstract class SoyaMilk {
    //模板方法, make , 模板方法可以做成 final , 不让子类去覆盖. 
    //==========================make方法不被覆盖，但是抽象方法addCondiments还是可以被覆盖==================
    final void make() {
        select();
//  这里调用钩子方法，默认是需要调味剂的；如果不要只需要在子类中覆盖钩子customerWantCondiments改为false即可
        if(customerWantCondiments())
            addCondiments();//调味剂
        soak();
        beat();
    }

    //选材料
    void select() {
        System.out.println("第一步：选择好的新鲜黄豆 ");
    }

    //添加不同的配料， 抽象方法, 子类具体实现
    abstract void addCondiments();

    //浸泡
    void soak() {
        System.out.println("第三步， 黄豆和配料开始浸泡， 需要 3 小时 ");
    }

    void beat() {
        System.out.println("第四步：黄豆和配料放到豆浆机去打碎 ");
    }

    //==========================钩子方法，决定是否需要添加配料============================
    boolean customerWantCondiments() {
        return true;
    }
}
