package observer.improve;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-2:39
 * @Function Description ：
 * //观察者接口，有观察者来实现
 */
public interface Observer {
    public void update(float temperature, float pressure, float humidity);

}
