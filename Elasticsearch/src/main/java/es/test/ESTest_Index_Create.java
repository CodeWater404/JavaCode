package es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

/**
 * @author ： CodeWater
 * @create ：2022-06-14-21:44
 * @Function Description ：
 * 创建索引
 */
public class ESTest_Index_Create {
    public static void main( String[] args ) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder( new HttpHost( "localhost" , 9200 , "http") )
        );
        
        CreateIndexRequest request = new CreateIndexRequest( "user1" );
        CreateIndexResponse response = 
                client.indices().create( request , RequestOptions.DEFAULT );
        
        boolean acknowledged = response.isAcknowledged();
        System.out.println( "索引操作：" + acknowledged );
        
        client.close();
        
    }
}
