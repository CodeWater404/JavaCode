package demo5.dao;

import demo5.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-06-16:29
 * @Function Description ：
 */
@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public void add( Book book ){
        String sql = "insert into t_book value(? , ? , ? )";
        Object[] args ={book.getUserId() , book.getUsername() , book.getUstatus() };
        int update = jdbcTemplate.update( sql , args );
        System.out.println( update );
    }
    
    @Override
    public void updateBook( Book book ){
        String sql = "update t_book set username=? , ustatus=? where user_id=?";
        Object[] args = {book.getUsername() , book.getUstatus() , book.getUserId() };
        int update = jdbcTemplate.update( sql , args );
        System.out.println( update );
    }
    
    @Override
    public void delete( String id){
        String sql = "delete from t_book where user_id = ?";
        int update = jdbcTemplate.update( sql , id );
        System.out.println( update );
    }
    
    @Override
    public int selectCount(){
        String sql = "select count(*) from t_book ";
        Integer count = jdbcTemplate.queryForObject( sql , Integer.class );
        return count;
    }
    
    @Override//查询返回一个对象
    public Book findBookInfo(String id){
        String sql = "select * from t_book where user_id = ?";
        Book book = jdbcTemplate.queryForObject( sql , new BeanPropertyRowMapper<Book>(Book.class) , id);
        return book;
    }
    
    @Override//查询返回集合
    public List<Book> findAllBook(){
        String sql = "select * from t_book ";
        List<Book> bookList = jdbcTemplate.query( sql , new BeanPropertyRowMapper<Book>(Book.class) );
        return bookList;
    }
    

    @Override//批量添加
    public void batchAddBook( List<Object[]> batchArgs ){
        String sql = "insert into t_book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate( sql , batchArgs );
        System.out.println( Arrays.toString(ints) );
    }
    
    @Override//批量修改
    public void batchUpdateBook( List<Object[]> batchArgs ){
        String sql = "update t_book set username=? , ustatus=?  where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate( sql , batchArgs );
        System.out.println( Arrays.toString(ints) );
    }
    
    @Override//批量删除
    public void batchDeleteBook( List<Object[]> batchArgs ){
        String sql = "delete from t_book where user_id=?";
        int[] ints = jdbcTemplate.batchUpdate( sql , batchArgs );
        System.out.println( Arrays.toString(ints) );
    }
}
