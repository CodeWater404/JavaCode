package observer.improve;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-2:39
 * @Function Description ：
 * 被观察者接口, 让 WeatherData 来实现
 */
public interface Subject {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();

}
