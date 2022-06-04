package optional;

import stream.Author;

import java.util.Optional;

/**
 * @author ： CodeWater
 * @create ：2022-06-04-22:36
 * @Function Description ：演示使用Optional封装安全的数据，不会报空指针异常
 */
public class OptionalDemo {
    public static void main(String[] args) {
//        空指针异常
//        Author author = getAuthor();
//        System.out.println( author.getAge() + 1 );
        
        //封装成optional
//        Optional<Author> author1 = Optional.ofNullable(author);
//        author1.ifPresent( name -> System.out.println( name.getName() ));
        
        //在方法中就封装成Optional
//        Optional<Author> op = getAuthor1();
//        op.ifPresent( name -> System.out.println( name.getName() ) );
        
        //安全的拿到值. 没有值就会返回一个方法体中的默认值（codewater）；有值的话就会返回值
        Optional<Author> op = getAuthor1();
        Author author = op.orElseGet( () -> new Author(1L,"codewater",20,"一个从菜刀中明悟哲理的祖安人",null) );
        System.out.println( author.getName() ) ;
        
        
        
    }
    
    public static Optional<Author> getAuthor1(){
        Author author = new Author(1L,"蒙多",33,"一个从菜刀中明悟哲理的祖安人",null);
//        return Optional.ofNullable( author );
        return Optional.ofNullable( null );
    }
    
    public static Author getAuthor(){
        Author author = new Author(1L,"蒙多",33,"一个从菜刀中明悟哲理的祖安人",null);
        return null;
    }
}
