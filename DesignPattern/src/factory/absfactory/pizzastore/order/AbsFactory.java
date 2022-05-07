package factory.absfactory.pizzastore.order;

import factory.absfactory.pizzastore.pizza.Pizza;

/**
 * @author ： CodeWater
 * @create ：2022-05-07-14:58
 * @Function Description ：抽象工厂
 */
//一个抽象工厂模式的抽象层(接口)
public interface AbsFactory {
    //让下面的工厂子类来 具体实现
    public Pizza createPizza(String orderType);

}
