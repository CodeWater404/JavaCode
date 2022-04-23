package file;

import java.io.File;

/**
 * @author ： CodeWater
 * @create ：2022-02-26-13:01
 * @Function Description ：
 * 问题：测试构建file类的时候，路径写反斜杠还是斜杠就行？
 * 解答：不管是文件还是目录都可以使用正反斜杠创建。
 * ps：1. java中"/"等同于"\\",但一般用"/"
 * 2. windows中的路径用"\"
 * 3. 在创建文件或者目录的时候的路径，不区分大小写
 */
public class FileDemo01 {
    public static void main(String[] args) {
//        文件
        File file1 = new File("E:/javavode/basics/src/file/file1.txt");
        System.out.println(file1.getAbsoluteFile());

        File file2 = new File("E:\\javacode\\basics\\src\\file\\file2.txt");
        System.out.println(file2.getAbsoluteFile());

//        目录
        File directory1 = new File("E:/javacodee/basics/src/file/directory1");
        System.out.println(directory1.getAbsoluteFile());

        File directory2 = new File("E:\\javacode\\basics\\src\\file\\directory2");
        System.out.println(directory2.getAbsoluteFile());

    }
}
