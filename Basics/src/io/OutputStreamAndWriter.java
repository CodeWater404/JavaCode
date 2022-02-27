package io;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ： CodeWater
 * @create ：2022-02-27-14:00
 * @Function Description ：
 * q:FileOutputStream不关闭流对象能否写出file文件中？（也就是有无缓冲区）
 *   FileWriter不关闭流，数据知识保存到缓冲区，未保存到文件，
 *  
 * a：FileOutputStream不关闭可以写出到文件中，应该是无缓冲区的
 *    FileWriter不关闭可用flush写出到文件，否则无法写出。
 * 
 */
public class OutputStreamAndWriter {
    public static void main(String[] args) throws IOException {
        //FileOutputStream,直接写文件是创建到工作根目录下
        FileOutputStream fos = new FileOutputStream("./basics/src/io/b.txt");
        //write只能传入int或char数组
        fos.write(97);
        fos.close();

        FileWriter fw = new FileWriter("./basics/src/io/c.txt");
        fw.write("好");
        fw.flush();//在不关闭流的时候可以写出到文件
//        fw.close();//没有flush也没有close会无法写入到文件
    }
}
