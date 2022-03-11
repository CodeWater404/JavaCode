package xml;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.File;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-03-11-14:26
 * @Function Description ：
 * XPath查询
 */
public class JsoupDemo06 {
    public static void main(String[] args) throws IOException , XpathSyntaxErrorException {
        String path = JsoupDemo06.class.getClassLoader().getResource( "xml/student.xml" ).getPath();
        Document document = Jsoup.parse( new File( path ) , "utf-8" );

        JXDocument jxDocument = new JXDocument( document );

        //4.结合xpath语法查询
        //4.1查询所有student标签
        List<JXNode> jxNodes = jxDocument.selN( "//student" );
        for( JXNode jxNode : jxNodes ){
            System.out.println( jxNode );
        }

//4.2查询所有student标签下的name标签
        List<JXNode> jxNodes2 = jxDocument.selN( "//student/name" );
        for( JXNode jxNode : jxNodes2 ){
            System.out.println( jxNode );
        }
        
        //4.3查询student标签下带有id属性的name标签
        List<JXNode> jxNodes3 = jxDocument.selN( "//student/name[@id]" );
        for( JXNode jxNode : jxNodes3 ){
            System.out.println( jxNode );
        }
        
        System.out.println( "------------------" );

        //4.4查询student标签下带有id属性的name标签 并且id属性值为itcast
        List<JXNode> jxNodes4 = jxDocument.selN( "//student/name[@id='itcast']" );
        for( JXNode jxNode : jxNodes4 ){
            System.out.println( jxNode );
        }
        
    }
}
