package factory.factorymethod.pizzastore.order;

import factory.factorymethod.pizzastore.pizza.LDCheesePizza;
import factory.factorymethod.pizzastore.pizza.LDPepperPizza;
import factory.factorymethod.pizzastore.pizza.Pizza;

/**
 * @author ： CodeWater
 * @create ：2022-05-06-16:07
 * @Function Description ：
 */
public class LDOrderPizza extends OrderPizza {
   

    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
// TODO Auto-generated method stub
        return pizza;
    }
}
