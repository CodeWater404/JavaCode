package lambda;

import java.util.function.Function;

/**
 * @author ： CodeWater
 * @create ：2022-03-01-18:31
 * @Function Description ：Function 接口中有一个默认的 andThen 方法，用来进行组合操作
 * 该方法同样用于“先做什么，再做什么”的场景，和 Consumer 中的 andThen 差不多：
 */
public class FunctionDemo02 {
    private static void method(Function<String, Integer> one, Function<Integer, Integer> two) {
        //one参数先把字符串解析为int，然后10加10为20；接着进行two参数自身乘10为200；最后输出的时候又加了20；所以是220
        int num = one.andThen(two).apply("10");
        System.out.println(num + 20);
    }

    public static void main(String[] args) {
        method(str -> Integer.parseInt(str) + 10, i -> i *= 10);
    }
}
