package lambda;

/**
 * @author ： CodeWater
 * @create ：2022-03-02-15:02
 * @Function Description ：
 * q:测试lambda输出的结果是hellworld还是传入的字符串
 * a:helloworld(虽然调用的时候有个参数s，但是实际上没有具体的参数传入)
 */
public class PrintableDemo {
    public static void main(String[] args) {
//        main中具体指明函数式接口的操作
        printString(s -> System.out.println(s));
    }

    //    printString只管调用printable接口
    private static void printString(Printable data) {
        data.print("Hello, World!");
    }
}
