package io;

import java.io.*;
import java.util.HashMap;

/**
 * @author ： CodeWater
 * @create ：2022-02-27-15:54
 * @Function Description ：
 * 将in.txt文本信息恢复顺序。
 * 步骤：1. 逐行读取文本信息。
 * 2. 解析文本信息到集合中。
 * 3. 遍历集合，按顺序，写出文本信息。
 */
public class BufferedDemo01 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> lineMap = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader("./basics/src/io/in.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("./basics/src/io/out.txt"));

        String line = null;
        //readLine返回读取的数据；FileReader的read是返回读取的状态
        while ((line = br.readLine()) != null) {
//           以点分隔成2部分，反斜杠是转义            
            String[] splitStr = line.split("\\.");
            //存进map中，不是分割
            lineMap.put(splitStr[0], splitStr[1]);
        }
        br.close();

        for (int i = 1; i <= lineMap.size(); i++) {
            //valueOf把整型转换为string
            String key = String.valueOf(i);
            String value = lineMap.get(key);
            bw.write(key + "." + value);
            bw.newLine();
        }
        bw.close();
    }
}
