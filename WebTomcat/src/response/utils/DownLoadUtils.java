package response.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-17:39
 * @Function Description ：
 */
public class DownLoadUtils {
    public static String getFileName( String agent  , String filename ) throws UnsupportedEncodingException {
        if( agent.contains( "MSIE" ) ){
            //IE
            filename = URLEncoder.encode( filename , "utf-8" );
            filename = filename.replace( "+" , " " );
            
        }else if( agent.contains( "Firefox" ) ){
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode( filename.getBytes("utf-8") ) + "?=_";
            
        }else{
            filename = URLEncoder.encode( filename , "utf-8" );
        }
        return filename;
    }
    
}
