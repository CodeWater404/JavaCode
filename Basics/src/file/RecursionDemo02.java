package file;

import java.io.File;
import java.io.FileFilter;
/**
 * @author ： CodeWater
 * @create ：2022-02-26-15:37
 * @Function Description ：
 * 搜索E：JavaCode下的.java文件(文件过滤器优化)
 * java.io.FileFilter是一个接口，是File的过滤器。 该接口的对象可以传递给File类的listFiles(FileFilter) 作为参数， 接口中只有一个方法。
 * boolean accept(File pathname) ：测试pathname是否应该包含在当前File目录中，符合则返回true。
 */
public class RecursionDemo02 {
    public static void main(String[] args){
        File dir = new File("e:/javacode");
        printDir(dir);
    }
    
    public static void printDir(File dir){
        File[] files = dir.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathName){
                //只有.java文件或者是目录才能返回ture接受到files数组中
                return pathName.getName().endsWith(".java") || pathName.isDirectory();
            }
        });
        
        for(File file : files){
            if(file.isFile()){
                System.out.println("文件名："+file.getAbsolutePath());
            }else{
                printDir(file);
            }
        }
    }
}
