package factory.absfactory.pizzastore.order;

import factory.absfactory.pizzastore.pizza.LDCheesePizza;
import factory.absfactory.pizzastore.pizza.LDPepperPizza;
import factory.absfactory.pizzastore.pizza.Pizza;

/**
 * @author ： CodeWater
 * @create ：2022-05-07-15:00
 * @Function Description ：
 */

public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}
