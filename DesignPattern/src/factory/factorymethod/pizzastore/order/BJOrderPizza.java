package factory.factorymethod.pizzastore.order;

import factory.simplefactory.pizzastore.pizza.Pizza;

/**
 * @author ： CodeWater
 * @create ：2022-05-06-16:07
 * @Function Description ：
 */
public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
// TODO Auto-generated method stub
        return pizza;
    }
}
