package es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author ： CodeWater
 * @create ：2022-06-14-22:35
 * @Function Description ：
 * 修改文档
 */
public class ESTest_Doc_Update {
    public static void main( String[] args ) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost" , 9200 , "http"))
        );
        
        //修改数据
        UpdateRequest request = new UpdateRequest();
        request.index("user1").id("1001");
        request.doc(XContentType.JSON , "sex" , "女" );

        UpdateResponse response = client.update( request , RequestOptions.DEFAULT );
        
        System.out.println( response.getResult() );
        
        client.close();
    }
}
