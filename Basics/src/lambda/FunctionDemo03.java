package lambda;

import java.util.function.Function;

/**
 * @author ： CodeWater
 * @create ：2022-03-01-18:38
 * @Function Description ：请使用 Function 进行函数模型的拼接，按照顺序需要执行的多个函数操作为：
 * String str = "赵丽颖,20";
 * 1. 将字符串截取数字年龄部分，得到字符串；
 * 2. 将上一步的字符串转换成为int类型的数字；
 * 3. 将上一步的int数字累加100，得到结果int数字。
 */
public class FunctionDemo03 {
    private static int getAgeNum(String str, Function<String, String> one, Function<String, Integer> two, Function<Integer, Integer> three) {
        //第一个one做完只有紧跟着two，two做完之后three，他们的参数是str
        return one.andThen(two).andThen(three).apply(str);
    }

    public static void main(String[] args) {
        String str = "赵丽颖,20";
        /*1.第一个lambda分隔出20
         * 2.第二个lamdba把字符20解析为int
         * 3.第三个lambda自身加100
         */
        int age = getAgeNum(str,
                s -> s.split(",")[1],
                s -> Integer.parseInt(s),
                n -> n += 100);
        System.out.println(age);
    }
}
