package es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @author ： CodeWater
 * @create ：2022-06-14-23:09
 * @Function Description ：
 * 各种查询操作
 */
public class ESTest_Doc_Query {
    public static void main( String[] args ) throws Exception {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder( new HttpHost( "localhost" , 9200 , "http"))
        );
        
//        -------------1.查询索引中的全部数据
//        SearchRequest request = new SearchRequest();
//        request.indices("user1");
//        
//        request.source( new SearchSourceBuilder().query(QueryBuilders.matchAllQuery() ) );
//
//        SearchResponse response = client.search(request , RequestOptions.DEFAULT );
//        SearchHits hits = response.getHits();
//        
//        System.out.println( hits.getTotalHits() );//所有数量是多少
//        System.out.println( response.getTook() );
//        
//        for( SearchHit hit : hits ){
//            System.out.println( hit.getSourceAsString() );
//        }
        
//        ----------------2.条件查询
        
        client.close();
    }
}
