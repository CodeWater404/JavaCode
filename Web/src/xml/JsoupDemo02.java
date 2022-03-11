package xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;
/**
 * @author ： CodeWater
 * @create ：2022-03-11-14:26
 * @Function Description ：
 * Jsoup对象功能
 */
public class JsoupDemo02 {
    
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo02.class.getClassLoader().getResource( "xml/student.xml" ).getPath();
        
        //1.解析xml文档， 加载文档进内存，获取dom树
//        Document document = Jsoup.parse( new File(path) , "utf-8" );
//        System.out.println( document );
        
        //2.解析xml、html字符串
//        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
//                "\n" +
//                "<students>\n" +
//                "\t<student number=\"heima_0001\">\n" +
//                "\t\t<name>tom</name>\n" +
//                "\t\t<age>18</age>\n" +
//                "\t\t<sex>male</sex>\n" +
//                "\t</student>\n" +
//                "\t<student number=\"heima_0002\">\n" +
//                "\t\t<name>jack</name>\n" +
//                "\t\t<age>18</age>\n" +
//                "\t\t<sex>female</sex>\n" +
//                "\t</student>\n" +
//                "\n" +
//                "</students>";
//        Document document = Jsoup.parse( str );
//        System.out.println( document );
        
        //3.通过网络路径获取指定的html或者xml文档对象
        URL url = new URL( "https://baike.baidu.com/item/jsoup/9012509?fr=aladdin" );
        Document document = Jsoup.parse( url , 10000 );
        System.out.println( document );
    }
}
