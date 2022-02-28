package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author ： CodeWater
 * @create ：2022-02-28-14:46
 * @Function Description ：简单的TCP网络程序；实现从客户端向服务器端写入数据
 * 客户端
 */
public class ClientTCP {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端，发送数据");
        Socket client = new Socket("localhost" , 6666);
        OutputStream os = client.getOutputStream();
        os.write("你好吗？tcp，我来了".getBytes());
        
        //-------客户端解析回写数据
        InputStream in = client.getInputStream();
        byte[] b = new byte[1024];
        int len = in.read(b);
        System.out.println(new String( b , 0 , len ) );
        in.close();
        os.close();
        client.close();
    }
}
