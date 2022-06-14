package es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author ： CodeWater
 * @create ：2022-06-14-22:53
 * @Function Description ：
 * 批量删除文档
 */
public class ESTest_Doc_Delete_Batch {
    public static void main( String[] args ) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient( 
                RestClient.builder( new HttpHost( "localhost" , 9200 , "http"))
        );

        BulkRequest request = new BulkRequest();
        request.add( new DeleteRequest().index("user1").id("1001") );
        request.add( new DeleteRequest().index("user1").id("1002") );
        request.add( new DeleteRequest().index("user1").id("1003") );

        BulkResponse response = client.bulk(request , RequestOptions.DEFAULT );
        System.out.println( response.getTook() );
        System.out.println( response.getItems() );
        
        client.close();
    }
}
