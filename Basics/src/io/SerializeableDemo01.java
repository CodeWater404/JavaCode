package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @author ： CodeWater
 * @create ：2022-02-28-12:38
 * @Function Description ：序列化集合练习
 * 1. 将存有多个自定义对象的集合序列化操作，保存到`list.txt`文件中。
 * 2. 反序列化`list.txt` ，并遍历集合，打印对象信息。
 * 注意：序列化的类要实现Serializeable接口
 */
public class SerializeableDemo01 {
    public static void main(String[] args) throws Exception {
        Student student = new Student("老王", "laoW");
        Student student2 = new Student("老张", "laoZ");
        Student student3 = new Student("老李", "laoL");

        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(student);
        arrayList.add(student2);
        arrayList.add(student3);
        //序列化操作(先注释掉下面执行；注释掉在执行下面的操作)
//        serializ(arrayList);

        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("list.txt"));
        ArrayList<Student> list = (ArrayList<Student>) ois.readObject();

        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.getName() + "---" + s.getPwd());
        }
    }

    private static void serializ(ArrayList<Student> arrayList) throws Exception {
        String path = "./Basics/src/io/list.txt";
        //创建序列化流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        //写出对象
        oos.writeObject(arrayList);
        oos.close();

    }
}
