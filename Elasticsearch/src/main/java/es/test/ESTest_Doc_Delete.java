package es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author ： CodeWater
 * @create ：2022-06-14-22:43
 * @Function Description ：
 * 删除文档
 */
public class ESTest_Doc_Delete {
    public static void main( String[] args ) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder( new HttpHost("localhost" , 9200 , "http"))
        );

        DeleteRequest request = new DeleteRequest();
        request.index("user1").id("1001");

        DeleteResponse response = client.delete(request , RequestOptions.DEFAULT );
        System.out.println( response.toString() );
        
        client.close();
    }
}
