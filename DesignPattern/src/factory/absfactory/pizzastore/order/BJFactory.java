package factory.absfactory.pizzastore.order;

import factory.absfactory.pizzastore.pizza.Pizza;
import factory.absfactory.pizzastore.pizza.BJCheesePizza;
import factory.absfactory.pizzastore.pizza.BJPepperPizza;

/**
 * @author ： CodeWater
 * @create ：2022-05-07-15:00
 * @Function Description ：
 */
//这是工厂子类
public class BJFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
// TODO Auto-generated method stub
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
