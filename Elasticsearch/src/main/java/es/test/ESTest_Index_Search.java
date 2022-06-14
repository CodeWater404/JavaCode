package es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

/**
 * @author ： CodeWater
 * @create ：2022-06-14-21:52
 * @Function Description ：
 * 查询索引
 */
public class ESTest_Index_Search {
    public static void main( String[] args ) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder( new HttpHost( "localhost" , 9200 , "http"))
        );
        
        GetIndexRequest request = new GetIndexRequest("user1");
        GetIndexResponse response = client.indices().get( request , RequestOptions.DEFAULT );
        
        System.out.println( response.getAliases() );
        System.out.println( response.getMappings() );
        System.out.println( response.getSettings() );
        
        client.close();
    }
}
