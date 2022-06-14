package es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author ： CodeWater
 * @create ：2022-06-14-22:43
 * @Function Description ：
 * 查询文档
 */
public class ESTest_Doc_Get {
    public static void main( String[] args ) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder( new HttpHost( "localhost" , 9200 , "http"))
        );

        GetRequest request = new GetRequest();
        request.index("user1").id("1001");

        GetResponse response = client.get(request , RequestOptions.DEFAULT );
        
        System.out.println( response.getSourceAsString() );
        
        client.close();
    }
}
