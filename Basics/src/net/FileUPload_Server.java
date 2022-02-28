package net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ： CodeWater
 * @create ：2022-02-28-15:03
 * @Function Description ：总和案列：文件上传
 * 服务器端
 */
public class FileUPload_Server {
    public static void main(String[] args) throws IOException{
        System.out.println("服务器启动。。。。");
        ServerSocket ss = new ServerSocket(6666);
        Socket accept = ss.accept();

        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream() );
//        String path = "./Basics/src/net/copy.jpg"; 
//        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path ));
        /*优化：服务端，保存文件的名称如果写死，那么最终导致服务器硬盘，只会保留一个文件，建议使用系统时间优化，保证文件名称唯一*/
        FileOutputStream fos = new FileOutputStream(System.currentTimeMillis() + ".jpg");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        
        byte[] b = new byte[1024 * 8 ];
        int len ;
        while( (len = bis.read(b)) != -1 ){
            bos.write(b , 0 , len );
            
        }
        bos.close();
        bis.close();
        accept.close();
        System.out.println("文件已经上传保存。。。。");
    }
}
