package xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.File;

/**
 * @author ： CodeWater
 * @create ：2022-03-11-14:26
 * @Function Description ：
 * Document/Element对象功能
 */
public class JsoupDemo03 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo03.class.getClassLoader().getResource("xml/student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);

        System.out.println("----------------");

        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("---------------");

        Elements elements2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elements2);

        System.out.println("-----------");
        Element itcast = document.getElementById("itcast");
        System.out.println(itcast);
    }
}
