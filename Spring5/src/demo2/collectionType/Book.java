package demo2.collectionType;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-22:15
 * @Function Description ：
 */
public class Book {
    private List<String> list;
    public void setList( List<String> list ){
        this.list = list;
    }
    
    public void test(){
        System.out.println( list );
    }
}
