package adapter.interfaceadapter;

/**
 * @author ： CodeWater
 * @create ：2022-05-09-18:32
 * @Function Description ：
 */
public class Client {
    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter() {
            //只需要去覆盖我们 需要使用 接口方法
            @Override
            public void m1() {
                // TODO Auto-generated method stub
                System.out.println("使用了 m1 的方法");
            }
        };
        absAdapter.m1();

    }
}
