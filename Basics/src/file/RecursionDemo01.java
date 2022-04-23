package file;

import java.io.File;

/**
 * @author ： CodeWater
 * @create ：2022-02-26-15:24
 * @Function Description ：
 * 搜索E：JavaCode下的.java文件(朴素实现)
 */
public class RecursionDemo01 {
    public static void main(String[] args) {
//        
        File dir = new File("e:/javacode");
        printDir(dir);
    }

    public static void printDir(File dir) {
        File[] files = dir.listFiles();


        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(".java")) {
                    System.out.println("文件名：" + file.getAbsolutePath());
                }
            } else {
                printDir(file);
            }
        }
    }
}
