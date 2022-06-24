import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

/**
 * @author ： CodeWater
 * @create ：2022-04-08-14:49
 * @Function Description ：测试一些疑问
 */
public class test {

    @Test//测试整数数组元素加1个char数组元素，的结果是啥
    public void test() {
        int[] a = {1, 2, 3};
        char[] b = {'a', 'b'};
        System.out.println((int) b[0]);
        a[0] += b[0];
//        char会自动转成对应的ascii码值，然后跟int变量相加
        System.out.println(a[0]);
    }

    @Test//测试二维数组的length是什么东西 ---->  行数（也对，二维其实相当于一维数组元素是个数组）
    public void test2() {
        int[][] a = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(a.length);//3二维的行数
        System.out.println(a[1].length);//2二维的列数
    }

    //测试取模:1000000007
    //1e9就是10的9次方整数，只不过是浮点数表示的
    @Test
    public void test3(){
//        double a = (1e9 );
        
        String a = scientificNotation2String( 1e9 , 10 );
        System.out.println( a );
    }

    public static String scientificNotation2String(Double d, int newValue) {
        String value = null;
        NumberFormat nf = NumberFormat.getInstance();
        // 设置此格式中不使用分组
        nf.setGroupingUsed(false);
        // 设置数的小数部分所允许的最大位数。
        nf.setMaximumFractionDigits(newValue);
        value = nf.format(d);
        return value;
    }

    //测试bufferedReader先用read再用readline是不是按照顺序读取输入----------------未完成---------------
    @Test
    public void test4() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in ) );
        String[] str = br.readLine().split(" ");
        int[] h = new int[5];
        int[] f = new int[5];
        for( int i = 0 ; i < 5 ;i++ ){
            h[i] = br.read() - '0';
            System.out.println("h[i]: " + h[i] );
        }

        for( int i = 0 ; i < 5 ;i++ ){
            str = br.readLine().split(" ") ;
            f[i] = Integer.parseInt(str[0]);
            System.out.println("h[i]: " + h[i] );
        }
    }
    
    //求公式和：1*2 + 3*4 + ... + 19 * 20 = ？
    @Test
    public void sum(){
        int res = 0;
        for( int i = 1 , j = 2 ; i <= 19 && j <= 20 ; i+=2 , j+=2 ){
            res += i * j;
        }
        System.out.println( res );
    }
    
    //求序列中第20个数：1 , 1 , 2, 3 , 5 , 8......
    @Test
    public void fibo(){
        int num = 0 ;
        int a = 1 , b = 1;
        for( int i = 3 ; i <= 20 ; i++ ){
            num = a + b;
            a = b;
            b = num;
        }
        System.out.println( num );
    }
    
    /** sql 1:查询没有被任何一个学生选修的课程信息
     * select * 
     * from subjects 
     * where subjects.jid not in (
     *             select jid
     *             from subjects ;      
     *     );
     */
    
    //sql 2:查询各学生选修了那些课程信息，要完整的学生信息和课程信息
    /**
     * select st.sid , st.sn , su.jid , su.jn 
     * from student st,subjects su , selects se 
     * where se.sid = st.sid and se.jid = su.jid;
     */
    
    /** 
     * 测试位运算符的操作对象类型：&  |  ^  ~  <<  >>  >>>
     * 位运算符，应用于整数类型(int)，长整型(long)，短整型(short)，
     * 字符型(char)，和字节型(byte)等类型。作用在所有的位上，并且按位运算
     * */
    @Test
    public void test5(){
        int l = -10000 , r = 1000;
        int mid = l + r >> 1;
        System.out.println(mid); //可以打印
        
//        double ll = -10000 , rr = 10000;
//        //在这里直接编译报错：Operator'>>'cannot be applied to 'double','int'
//        double mid2 = ll + rr >> 1; 
//        System.out.println(mid2);
        
        char ll = '1' , rr = '5';
//        不兼容的类型：从int转换到char可能会有损失
//        char mid3 = ll + rr >> 1;
//        -------------正确写法
        char mid3 = (char) (ll + rr >> 1);

        byte a = -1 , b = 1 ;
//        不兼容的类型：从int转换到byte可能会有损失
//        byte mid2 = a + b >> 1;
//        -------正确写法
        byte mid2 = (byte) (a + b >> 1);
        
//        short ll = -10 , rr = 5;
//        // 不兼容的类型：从int转换到byte可能会有损失
//        short mid2 = ll + rr >> 1;
        //正确写法
////        short mid2 = (short) (ll + rr >> 1);
//        System.out.println(mid2);
    }

    /**
     * char转string
     * 更多方法：https://blog.csdn.net/weixin_32396347/article/details/114628726
     */
    @Test
    public void test6(){
        char a  = 'a';
        System.out.println(a);
//        不能直接转
//        String b = (String) a;
        String b = String.valueOf(a);
    }

    /**
     * 测试string的length（）下标是从0开始还是1---------------------------------1
     */
    @Test
    public void test7(){
        String a = "123";
        System.out.println(a.length());
        System.out.println(a.charAt(0));
    }
}
