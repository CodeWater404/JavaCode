package lambda;

import java.util.function.Consumer;

/**
 * @author ： CodeWater
 * @create ：2022-03-01-15:58
 * @Function Description ：andThen接口练习
 * 按照格式“ 姓名：XX。性别：XX。 ”的格式将信息打印出来。要求将打印姓
 * 名的动作作为第一个 Consumer 接口的Lambda实例，将打印性别的动作作为第二个 Consumer 接口的Lambda实
 * 例，将两个 Consumer 接口按照顺序“拼接”到一起。
 * String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
 */
public class AndThenDemo {
    public static void main(String[] args){
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        printInfo(
                s -> System.out.print("姓名："+ s.split(",")[0] ) ,
                s -> System.out.println("，性别：" + s.split(",")[1] + "。" ) ,
                array
        );
    }
    
    private static void printInfo(Consumer<String>one , Consumer<String> two , String[] array){
        for(String info : array){
            one.andThen(two).accept(info);
        }
    }
}
