package xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
/**
 * @author ： CodeWater
 * @create ：2022-03-11-14:26
 * @Function Description ：
 * Element对象功能
 */
public class JsoupDemo04 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo04.class.getClassLoader().getResource( "xml/student.xml" ).getPath();
        Document document = Jsoup.parse( new File( path ) , "utf-8" );
        
        Elements elements = document.getElementsByTag( "name" );
        System.out.println( elements.size() );
        System.out.println( "------------" );
        
        Element element_student = document.getElementsByTag( "student" ).get( 0 );
        Elements ele_name = element_student.getElementsByTag( "name" );
        System.out.println( ele_name );
        System.out.println( ele_name.size() );
        System.out.println( "-----------------" );
        
        String number = element_student.attr( "NUMBER" );
        System.out.println( number );
        System.out.println( "-----------------" );
        
        String text = ele_name.text();
        String html = ele_name.html();
        System.out.println( text );
        System.out.println( "-----------------" );
        System.out.println( html );
    }
}
