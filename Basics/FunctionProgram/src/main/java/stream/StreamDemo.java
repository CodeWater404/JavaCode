package stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ： CodeWater
 * @create ：2022-06-03-23:27
 * @Function Description ：
 * 我们可以调用getAuthors方法获取到作家的集合。现在需要打印所有年龄小于18的作家的名字，并且要注意去重。
 * 需求： 用stream流方式写
 */

public class StreamDemo {

    public static void main(String[] args) {
//        test01();
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
        test07();
        
        
        
    }

    /** reduce: 一个参数的使用
     * 需求： 使用reduce求所有作者中年龄的最小值
     */
    private static void test07() {
        List<Author> authors = getAuthors();
        //reduce(参数是方法体内要进行的具体的操作的参数！ )
        //方法体要进行的操作就是那参数的第一个元素作为初始值，然后进行方法体的操作赋给那个初始值 ，
        // 不断更新，从而求得最小值
        Optional<Integer> min = authors.stream()
                .map(author -> author.getAge())
                .reduce((age1, age2) -> age1 > age2 ? age2 : age1);  //求最小值，为true用小的age2赋值
        
        min.ifPresent( age -> System.out.println( age ) );
    }

    /** reduce两个参数
     * 需求： 使用reduce求所有作者中年龄的最大值
     */
    private static void test06() {
        List<Author> authors = getAuthors();
        //reduce(第一个参数是初始化的值 ， 第二个参数是方法体内要进行的具体的操作的参数！ )
        //方法体要进行的操作之后的结果赋给第一个参数，不断更新，从而求得最大值
        Integer max = authors.stream()
                .map(author -> author.getAge())
                .reduce( Integer.MIN_VALUE , (age1, age2) -> age1 > age2 ? age1 : age2);
        
        System.out.println( max );
    }

    /** anyMatch:只要有一个符合条件的就是true
     * 需求：判断是否有年龄在29以上的作家
     */
    private static void test05() {
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println( b );
    }

    /**
     * 获取一个Map集合，map的key为作者名，value为List<Book>
     */
    private static void test04() {
        List<Author> authors = getAuthors();
        Map<String , List<Book> > map = authors.stream()
               .distinct()
               .collect( Collectors.toMap( author -> author.getName() , author -> author.getBooks() ) );
        //toMap( 第一个参数是选取一个元素作为键 ， 第二个参数是选取一个元素作为值 ）；

        System.out.println( map );
    }

    /**
     * 需求：打印现有书的所有分类。要求对分类进行去重。不能出现这种格式：哲学,爱情
     * 分析：作家----书----分类； 需要进行两次flatMap
     */
    private static void test03() {
        List<Author> authors = getAuthors();
        authors.stream()
               .flatMap( author -> author.getBooks().stream() )
               .distinct()   //对书去重
               .flatMap( book -> Arrays.stream( book.getCategory().split(",") ) )
               .distinct()   //对分类字符串去重
               .forEach( category -> System.out.println( category ) ); 
    }

    /** flatMap：把一个对象转换成多个对象作为流中的元素。
     * 需求：打印所有书籍的名字。要求对重复的元素进行去重。
     * 分析：书籍是在作家的属性当中，而且getAuthors方法只能获得作家列表。所以需要先获取作家有哪些，
     * 然后再把每一个作家转换成他所有的书的多个对象
     */
    private static void test02() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap( author -> author.getBooks().stream() )
                .distinct()
                .forEach( book -> System.out.println( book.getName() ) );
    }

    /**
     * 对作家去重。选出年龄小于18的，然后打印出作家的名字.
     */
    public static void test01(){
        List<Author> authors = getAuthors();
        //集合list不是stream流，不能直接操作，需要转换一下
        authors.stream()
                .distinct()  //去重
                .filter( author ->  author.getAge() < 18 )  //过滤处年龄小于18的
                .forEach( author -> System.out.println( author.getName() ) );  //打印
        
    }
    
    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L,"蒙多",33,"一个从菜刀中明悟哲理的祖安人",null);
        Author author2 = new Author(2L,"亚拉索",15,"狂风也追逐不上他的思考速度",null);
        Author author3 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);
        Author author4 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L,"刀的两侧是光明与黑暗","哲学,爱情",88,"用一把刀划分了爱恨"));
        books1.add(new Book(2L,"一个人不能死在同一把刀下","个人成长,爱情",99,"讲述如何从失败中明悟真理"));

        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(4L,"吹或不吹","爱情,个人传记",56,"一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L,"你的剑就是我的剑","爱情",56,"无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author,author2,author3,author4));
        return authorList;
    }
}
