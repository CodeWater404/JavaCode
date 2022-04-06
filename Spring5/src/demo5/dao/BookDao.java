package demo5.dao;

import demo5.entity.Book;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-06-16:29
 * @Function Description ：
 */
public interface BookDao {
     void add(Book book );
     void updateBook( Book book );
    void delete( String id );
    int selectCount();
    Book findBookInfo(String id);
    List<Book> findAllBook();
    void batchAddBook( List<Object[]> batchArgs );
    void batchUpdateBook( List<Object[]> batchArgs );
    void batchDeleteBook( List<Object[]> batchArgs );
}
