package es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

/**
 * @author ： CodeWater
 * @create ：2022-06-14-22:22
 * @Function Description ：
 * 插入文档
 */
public class ESTest_Doc_Insert {
    
    public static void main( String[] args ) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder( new HttpHost("localhost" , 9200 , "http"))
        );

        IndexRequest request = new IndexRequest();
//        这里其实就创建了一个索引user1 ，并且设置它的id为1001
        request.index("user1").id("1001");
        
        User user = new User();
        user.setName("zhangsan");
        user.setAge(20);
        user.setSex("male");

        // 向ES插入数据，必须将数据转换位JSON格式
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString( user );
        request.source( userJson  , XContentType.JSON );
        
        IndexResponse response = client.index( request , RequestOptions.DEFAULT );
        
        System.out.println( response.getResult() );
        
        client.close();
    }
}
