package es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author ： CodeWater
 * @create ：2022-06-14-22:13
 * @Function Description ：
 * 删除索引
 */
public class ESTest_Index_Delete {
    public static void main( String[] args ) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient( 
                RestClient.builder( new HttpHost( "localhost" , 9200 ,"http"))
        );

        DeleteIndexRequest request = new DeleteIndexRequest("user1");
        
        AcknowledgedResponse response = client.indices().delete(request , RequestOptions.DEFAULT );
        
        System.out.println( response.isAcknowledged() );
        
        client.close();
    }
}
