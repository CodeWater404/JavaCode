package es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author ： CodeWater
 * @create ：2022-06-14-22:54
 * @Function Description ：
 * 批量新增文档
 */
public class ESTest_Doc_Insert_Batch {
    public static void main( String[] args ) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder( new HttpHost("localhost" , 9200 , "http"))
        );
        
        //批量插入
        BulkRequest request = new BulkRequest();
        request.add( new IndexRequest().index("user1").id("1001").source(XContentType.JSON , "name", "zhangsan" , "age" , "20" , "sex" , "male"));
        request.add( new IndexRequest().index("user1").id("1002").source(XContentType.JSON , "name", "lisi" , "age" , "24" , "sex" , "female"));
        request.add( new IndexRequest().index("user1").id("1003").source(XContentType.JSON , "name", "wangwu" , "age" , "65" , "sex" , "male"));
        request.add( new IndexRequest().index("user1").id("1004").source(XContentType.JSON , "name", "wangwu1" , "age" , "76" , "sex" , "female"));
        request.add( new IndexRequest().index("user1").id("1005").source(XContentType.JSON , "name", "wangwu2" , "age" , "42" , "sex" , "female"));
        request.add( new IndexRequest().index("user1").id("1006").source(XContentType.JSON , "name", "wangwu3" , "age" , "65" , "sex" , "male"));
        request.add( new IndexRequest().index("user1").id("1007").source(XContentType.JSON , "name", "wangwu4" , "age" , "28" , "sex" , "female"));
        request.add( new IndexRequest().index("user1").id("1008").source(XContentType.JSON , "name", "wangwu5" , "age" , "29" , "sex" , "male"));

        BulkResponse response = client.bulk( request , RequestOptions.DEFAULT );
        
        System.out.println( response.getTook() ); //耗费时间
        System.out.println( response.getItems() );
        
        client.close();
    }
}
