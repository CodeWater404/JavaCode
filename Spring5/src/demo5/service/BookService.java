package demo5.service;

import demo5.dao.BookDao;
import demo5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-06-16:28
 * @Function Description ：
 */
@Service
public class BookService {
    
    @Autowired
    private BookDao bookDao;
    
   public void addBook(Book book ){
       bookDao.add( book );
   }
   
   public void updateBook(Book book ){
       bookDao.updateBook( book );
   }
   
   public void deleteBook( String id ){
       bookDao.delete( id );
   }
   
   
   public int findCount(){
       return bookDao.selectCount();
   }
   
//   查询返回一个对象
    public Book findOne( String id ){
       return bookDao.findBookInfo( id );
    }
    
//    查询返回集合
    public List<Book> findAll(){
       return bookDao.findAllBook();
    }
    
//    批量添加
    public void batchAdd(List<Object[]> batchArgs){
       bookDao.batchAddBook( batchArgs );
    }
    
//    批量修改
    public void batchUpdate(List<Object[]> batchArgs ){
       bookDao.batchUpdateBook( batchArgs );
    }
    
//    批量删除
    public void batchDelete( List<Object[]> batchArgs ){
       bookDao.batchDeleteBook(batchArgs);
    }
}
