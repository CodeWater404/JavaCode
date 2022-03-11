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
 * Jsoup快速入门
 */
public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo01.class.getClassLoader().getResource("xml/student.xml").getPath();
        
        Document document = Jsoup.parse( new File(path) , "utf-8" );
        Elements elements = document.getElementsByTag( "name" );
        
        System.out.println( elements.size() );
        
        Element element = elements.get(0);
        String name = element.text();
        System.out.println( name );
    }
}
