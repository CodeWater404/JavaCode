package template;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-2:04
 * @Function Description ：
 */
public class PureSoyaMilk extends  SoyaMilk{
    @Override
    void addCondiments() {
        //空实现
    }

//    这里覆盖钩子函数：决定不加调味剂
    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
