package io;

import java.io.*;

/**
 * @author ： CodeWater
 * @create ：2022-02-28-12:03
 * @Function Description ：缓冲流的练习
 * 将GBK编码的文本文件，转换为UTF-8编码的文本文件。
 */
public class InputStreamReaderAndOutputStreamWriter {
    public static void main(String[] args) throws IOException {
        String srcFile = "./Basics/src/io/file_gbk.txt";
        String destFile = "./Basics/src/io/file_utf8.txt";

        InputStreamReader isr = new InputStreamReader(new FileInputStream(srcFile), "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(destFile));

        char[] cbuf = new char[1024];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            osw.write(cbuf, 0, len);
        }
        osw.close();
        isr.close();
    }
}
