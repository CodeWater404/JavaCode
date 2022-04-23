package lambda;

import java.util.function.Consumer;

/**
 * @author ： CodeWater
 * @create ：2022-03-01-15:49
 * @Function Description ：lambda练习
 * 如果一个方法的参数和返回值全都是 Consumer 类型，那么就可以实现效果：消费数据的时候，首先做一个操作，
 * 然后再做一个操作，实现组合。而这个方法就是 Consumer 接口中的default方法 andThen 。
 */
public class ConsumerAndThen {
    private static void consumerString(Consumer<String> one, Consumer<String> two) {
        one.andThen(two).accept("hello");
    }

    public static void main(String[] args) {
        //lambda
        consumerString(s -> System.out.println(s.toUpperCase()),
                s -> System.out.println(s.toLowerCase())
        );
    }
}
