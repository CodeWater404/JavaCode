package net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author ： CodeWater
 * @create ：2022-02-28-15:04
 * @Function Description ：总和案列：文件上传
 * 客户端
 */
public class FileUPload_Client {
    public static void main(String[] args) throws IOException {
        String path = "./Basics/src/net/java.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path) );
        Socket socket = new Socket("localhost" , 6666 );
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] b = new byte[1024 * 8 ];
        int len ;
        while( (len = bis.read(b)) != -1 ){
            bos.write(b , 0 , len );
            //刷新流，写出到文件
            bos.flush();
        }
        System.out.println("文件发送完毕。");
        
        bos.close();
        socket.close();
        bis.close();
        System.out.println("文件上传完毕。。。");
    }
}
