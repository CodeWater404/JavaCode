package xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.File;
/**
 * @author ： CodeWater
 * @create ：2022-03-11-14:26
 * @Function Description ：
 * 选择器查询
 */
public class JsoupDemo05 {
    public static void main(String[] args) throws IOException{
        String path = JsoupDemo05.class.getClassLoader().getResource( "xml/student.xml" ).getPath();
        Document document = Jsoup.parse( new File( path ) , "utf-8" );
        
        Elements elements = document.select( "name" );
        System.out.println( elements );
        System.out.println( "= -----------------");
        
        Elements elements1 = document.select( "#itcast" );
        System.out.println( elements );
        System.out.println( "---------------------" );
        
        Elements elements2 = document.select( "student[number=\"heima_0001\"]" );
        System.out.println( elements2 );
        System.out.println( "-------------" );

        //5.2获取student标签并且number属性值为heima_0001的age子标签
//        select里面不能有多余的空格，比如age后面多个，不然就会报错
        Elements elements3 = document.select( "student[number=\"heima_0001\"] > age" );
        System.out.println( elements3 );
    }
    
}
