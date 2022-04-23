package file;

import java.io.File;

/**
 * @author ： CodeWater
 * @create ：2022-02-26-15:00
 * @Function Description ：
 * 递归打印多级目录和文件
 */
public class Recursion {
    public static void main(String[] args) {
        File dir = new File("E:\\javacode");
        printDir(dir);
    }

    //    递归方法
    public static void printDir(File dir) {
        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("文件名:" + file.getAbsolutePath());
            } else {
                System.out.println("目录：" + file.getAbsolutePath());
                //继续递归遍历
                printDir(file);
            }
        }
    }
}
