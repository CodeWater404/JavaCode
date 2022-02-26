package file;

import java.io.File;
/**
 * @author ： CodeWater
 * @create ：2022-02-26-15:47
 * @Function Description ：
 * 搜索E：JavaCode下的.java文件(lambda优化FileFilter接口)
 */
public class RecursionDemo03 {
    public static void main(String[] args){
        File dir = new File("e:/javacode");
        
        printDir(dir);
    }
    
    public static void printDir(File dir){
        File[] files = dir.listFiles(f -> {
           return f.getName().endsWith(".java") || f.isDirectory(); 
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
