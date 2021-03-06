package es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

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
        
//        ----------------2.条件查询:termQuery
//        SearchRequest request = new SearchRequest();
//        request.indices("user1");
//        request.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age" , 20)));
//
//        SearchResponse response = client.search( request , RequestOptions.DEFAULT );
//        SearchHits hits = response.getHits();
//        
//        System.out.println( hits.getTotalHits() );
//        System.out.println( response.getTook() );
//        
//        for( SearchHit hit : hits ){
//            System.out.println( hit.getSourceAsString() );
//        }
        
//        -----------------3.分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user1");
//        
//        SearchSourceBuilder builder = new SearchSourceBuilder().query( QueryBuilders.matchAllQuery() );
//        // (当前页码-1)*每页显示数据条数
//        builder.from(0);
//        builder.size(2);
//        request.source( builder );
//
//        SearchResponse response = client.search( request , RequestOptions.DEFAULT );
//
//        SearchHits hits = response.getHits();
//        System.out.println( hits.getTotalHits() );
//        System.out.println( response.getTook() );
//        
//        for(SearchHit hit : hits ){
//            System.out.println( hit.getSourceAsString() );
//        }
        
//        ----------------4.查询排序
//        SearchRequest request = new SearchRequest();
//        request.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery() );
//        builder.sort("age" , SortOrder.DESC );
//        
//        request.source( builder );
//        SearchResponse response = client.search( request , RequestOptions.DEFAULT );
//        
//        SearchHits hits = response.getHits();
//        System.out.println( hits.getTotalHits() );
//        System.out.println( response.getTook() );
//        
//        for(SearchHit hit : hits ){
//            System.out.println( hit.getSourceAsString() );
//        }
        
//        --------------------5.过滤字段
//        SearchRequest request = new SearchRequest();
//        request.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        String[] excludes = {}; //除了age
//        String[] includes = {"age"}; //包括age
//        builder.fetchSource( includes , excludes );
//        
//        request.source( builder );
//        SearchResponse response = client.search( request , RequestOptions.DEFAULT );
//        SearchHits hits = response.getHits();
//        
//        System.out.println( hits.getTotalHits() );
//        System.out.println( response.getTook() );
//        
//        for(SearchHit hit : hits ){
//            System.out.println( hit.getSourceAsString() );
//            
//        }
        
//        ------------------6.组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        
////        boolQueryBuilder.must(QueryBuilders.matchQuery("age" , 65));
////        boolQueryBuilder.must(QueryBuilders.matchQuery("sex" , "male"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("sex" , "male"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("sex" , "female"));
//        
//        builder.query( boolQueryBuilder );
//        
//        request.source( builder );
//        SearchResponse response = client.search( request , RequestOptions.DEFAULT );
//
//        SearchHits hits = response.getHits();
//        
//        System.out.println( hits.getTotalHits() );
//        System.out.println( response.getTook() );
//        
//        for(SearchHit hit : hits ){
//            System.out.println( hit.getSourceAsString() );
//        }
        
//      ----------------7. 范围查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user1");
//        
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//        
//        rangeQuery.gte( 30 );  //20 <= age < 90
//        rangeQuery.lt( 90 );
//        
//        builder.query( rangeQuery );
//        
//        request.source( builder );
//        SearchResponse response = client.search( request , RequestOptions.DEFAULT );
//        
//        SearchHits hits = response.getHits();
//        
//        System.out.println( hits.getTotalHits() );
//        System.out.println( response.getTook() );
//        
//        for(SearchHit hit : hits ){
//            System.out.println( hit.getSourceAsString() );
//        }
        
//        -------------8.模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
////        fuzziness(Fuzziness.TWO)意思是给定的值和查询的数据差别在2个字符之内就能查询出来
////        builder.query( QueryBuilders.fuzzyQuery("name" , "zhangn").fuzziness(Fuzziness.TWO));
//        builder.query( QueryBuilders.fuzzyQuery("name" , "wangwu").fuzziness(Fuzziness.TWO));
//        
//        request.source(builder);
//        SearchResponse response = client.search( request , RequestOptions.DEFAULT );
//        SearchHits hits = response.getHits();
//        
//        System.out.println( hits.getTotalHits() );
//        System.out.println( response.getTook() );
//        
//        for(SearchHit hit : hits ){
//            System.out.println( hit.getSourceAsString() );
//        }
        
//        ----------------9.高亮查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user1");
//        
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("name" , "zhangsan");
//
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//        
//        builder.highlighter( highlightBuilder );
//        builder.query( termsQueryBuilder );
//        
//        request.source( builder );
//        SearchResponse response = client.search( request , RequestOptions.DEFAULT );
//
//        SearchHits hits = response.getHits();
//        
//        System.out.println( hits.getTotalHits() );
//        System.out.println( response.getTook() );
//        
//        for(SearchHit hit : hits ){
//            System.out.println( hit.getSourceAsString() );
//        }
        
//        --------------10.聚合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user1");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
////      查询最大的年龄，在打印日志里面能看到
//        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//        builder.aggregation( aggregationBuilder );
//        
//        request.source( builder );
//        SearchResponse response = client.search( request , RequestOptions.DEFAULT );
//
//        SearchHits hits = response.getHits();
//        System.out.println( hits.getTotalHits() );
//        System.out.println( response.getTook() );
//        
//        for(SearchHit hit : hits ){
//            System.out.println( hit.getSourceAsString() );
//        }
        
//        --------------11.分组查询
        SearchRequest request = new SearchRequest();
        request.indices("user1");
        
        SearchSourceBuilder builder = new SearchSourceBuilder();

        AggregationBuilder aggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");
        builder.aggregation( aggregationBuilder );
        
        request.source( builder );
        SearchResponse response = client.search( request , RequestOptions.DEFAULT );

        SearchHits hits = response.getHits();
        System.out.println( hits.getTotalHits() );
        System.out.println( response.getTook() );
        
        for(SearchHit hit : hits ){
            System.out.println( hit.getSourceAsString() );
        }
        
        
        client.close();
    }
}
