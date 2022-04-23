package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ： CodeWater
 * @create ：2022-02-28-14:40
 * @Function Description ：简单的TCP网络程序；实现从客户端向服务器端写入数据
 * 服务器端
 */
public class ServerTCP {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器端启动，等待连接中.......");

        ServerSocket ss = new ServerSocket(6666);
        //接收连接accept方法，返回socket对象
        Socket server = ss.accept();
        InputStream is = server.getInputStream();

        byte[] b = new byte[1024];
        int len = is.read(b);
//        read方法返回的是读取的数据长度；参数是写入数据的存储地方
//        System.out.println("InputStrean流read方法返回的数据: " + len );
        String msg = new String(b, 0, len);
        System.out.println(msg);

        //----------向客户端回写数据--------------
        OutputStream out = server.getOutputStream();
        out.write("我很好，谢谢你".getBytes());
        out.close();
        is.close();
        server.close();
    }
}
