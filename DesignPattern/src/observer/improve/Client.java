package observer.improve;


/**
 * @author ： CodeWater
 * @create ：2022-06-25-2:38
 * @Function Description ：
 */
public class Client {
    public static void main(String[] args) {
// TODO Auto-generated method stub
//创建一个 WeatherData----------------------被观察的
        WeatherData weatherData = new WeatherData();
//创建观察者
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduSite baiduSite = new BaiduSite();
//注册到 weatherData-------------其实添加到集合中去了
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduSite);
//测试
        System.out.println("通知各个注册的观察者, 看看信息");
        weatherData.setData(10f, 100f, 30.3f);
        weatherData.removeObserver(currentConditions);
//测试
        System.out.println();
        System.out.println("通知各个注册的观察者, 看看信息");
        weatherData.setData(10f, 100f, 30.3f);
    }
}
