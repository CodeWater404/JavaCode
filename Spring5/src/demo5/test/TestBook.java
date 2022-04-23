package demo5.test;

import demo5.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-06-17:18
 * @Function Description ：
 */
public class TestBook {

    @Test
    public void testJdbcTemplate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("/demo5/bean1.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
//        添加
//        Book book = new Book();
//        book.setUserId("1");
//        book.setUsername("java");
//        book.setUstatus("a");
//        bookService.addBook( book );

//        修改
//        Book book = new Book();
//        book.setUserId("1");
//        book.setUsername("java.........");
//        book.setUstatus("d");
//        bookService.updateBook( book );

//        删除
//        bookService.deleteBook( "1" );

        //查询总数
//        System.out.println( "数据库中的数据总数是：" + bookService.findCount() );

//        查询返回一个对象
//        Book book = bookService.findOne( "1" );
//        System.out.println( book );

//        查询返回一个集合
//        List<Book> bookList = bookService.findAll();
//        System.out.println( bookList );

//        批量添加
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"4" ,"jaba" ,"a" }; 
//        Object[] o2 = {"5" ,"C++" ,"b" }; 
//        Object[] o3 = {"6" ,"node" ,"c" };
//        batchArgs.add(o1);
//        batchArgs.add(o2);
//        batchArgs.add(o3);
////        输出影响的行数
//        bookService.batchAdd( batchArgs );

//        批量修改
//        List<Object[]> batchArgs = new ArrayList<>();
//        Object[] o1 = {"m" ,"a" ,"4"  }; 
//        Object[] o2 = {"p" ,"5" ,"5"  }; 
//        Object[] o3 = {"l" ,"6" ,"6"  }; 
//        batchArgs.add( o1 );
//        batchArgs.add( o2 );
//        batchArgs.add( o3 );
//        bookService.batchUpdate( batchArgs );

//        批量删除
        List<Object[]> batchArgs = new ArrayList<>();
        Object[] o1 = {"4"};
        Object[] o2 = {"5"};
        Object[] o3 = {"6"};
        batchArgs.add(o1);
        batchArgs.add(o2);
        batchArgs.add(o3);
        bookService.batchDelete(batchArgs);

    }
}
