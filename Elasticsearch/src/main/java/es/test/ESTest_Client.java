package es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author ： CodeWater
 * @create ：2022-06-14-21:33
 * @Function Description ：
 * 测试连接Elasticsearch
 */
public class ESTest_Client {
    public static void main( String[] args) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder( new HttpHost("localhost" , 9200 , "http") )
        );
        
        client.close();
    }
}
