package io;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-02-27-12:29
 * @Function Description ：
 * q：测试io流循环读取的时候为什么要多加一个括号，去掉会不会有什么影响？
 * a：看岔了，read方法有一个（），还需要一个（）把len包起来的括号
 */
public class FileReaderDemo01 {
    public static void main(String[] args) throws IOException {
        //获取当前工作的根目录
//        System.out.println(System.getProperty("user.dir"));
        FileReader fr = new FileReader("e:/javacode/basics/src/io/a.txt");
        //定义变量，保存有效字符个数。其实仅作为判断是否读到空，虽然名字叫len
        int len ;
        //字符数组，作为装字符串数据的容器
        char[] cbuf = new char[2];
        
        //循环读取，read方法读取到数据返回int数值表示状态，-1为空；里面加个参数是把数据读入到里面去
        while( (len = fr.read(cbuf)) != -1 ){
            //read方法每次读取一个字符，这里是因为用了字符数组，
            System.out.println(new String(cbuf));    
        }
        
        fr.close();
    }
}
