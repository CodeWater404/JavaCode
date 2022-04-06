package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-04-06-11:42
 * @Function Description ：模拟散列表
 * 
 */
public class _840SimulateHash {
    /*开放寻址法，取的数要是原数据范围的2-3倍，且最好是一个质数（n如果为偶数，那么就会使
的奇数只会在奇数位置上，偶数只会在偶数位置上，造成冲突的概率比较大），装载因子最好
是0.5，这样从经验上来说效率比较高。
*/
    public static int N = 200003;
    //null是定义一个数据范围之外的数，标记某个数在哈希表是否存在
    public static int Null = 0x3f3f3f3f;
    // h哈希表
    public static int[] h = new int[N];
    // n操作次数
    public static int n;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );

        // 初始化哈希表
        for( int i = 0 ; i < N ; i++ )h[i] = Null;

        while( n-- > 0 ){
            str = br.readLine().split(" ");
            String op = str[0];
            int x;
            // 插入一个数
            if( op.equals("I") ){
                x = Integer.parseInt( str[1] );
                h[find(x)] = x;
            }else{
                // 查询一个数
                x = Integer.parseInt( str[1] );
                // 表中该位置不是Null则有这个数
                if(h[find(x)] != Null ) System.out.println( "Yes" );
                else System.out.println( "No" );

            }
        }
    }

    // 查询哈希表中是否有一个数x
    public static int find( int x ){
 /*t哈希值。把−109≤x≤109映射到1≤N≤105 。
    Java中：取模运算，负数取模是负数，正数取模是正数。所以这里+N之后就一定
    是一个整数，然后再模N，变回正数的模。
    */
        int t = ( x % N + N ) % N;
        // 哈希出的位置有值了，往后找
        while( h[t] != Null && h[t] != x ){
            t++;
            // 找到结尾还是有值，再从头找
            if( t == N ) t = 0;
        }
        // 返回位置
        return t;
    }
}

/*----------------------拉链法处理冲突-----------------------------*/
//import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.io.BufferedReader;
//
//public class Main{
//    /*
//拉链法模一个数，这个数最好是个质数，这样冲突的概率就会少一点。由于大于10的第一个
//质数是100003，所以N取这个数。
//*/
//    public static int N = 100003;
//    //h数组：哈希表存放数的空间   e数组模拟链表，存放的值   ne是链表的指针指向下一个元素
//    public static int[] h = new int[N];
//    public static int[] e = new int[N];
//    public static int[] ne = new int[N];
//    // idx链表当前用到了哪个位置
//    public static int idx = 0 ;
//    public static int n ;
//
//    public static void main( String[] args ) throws IOException {
//        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
//        String[] str = br.readLine().split(" ");
//        n = Integer.parseInt( str[0] );
//
//        // 初始哈希表，用-1表示空
//        for( int i = 0 ; i < N ; i++ ) h[i] = -1;
//
//        while( n-- > 0 ){
//            str = br.readLine().split(" ");
//            String op = str[0];
//            int x ;
//            if( op.equals("I") ){
//                x = Integer.parseInt( str[1] );
//                insert( x );
//            }else {
//                x = Integer.parseInt( str[1] );
//                if( find( x ) ) System.out.println( "Yes" );
//                else System.out.println( "No" );
//            }
//        }
//    }
//
//    public static void insert( int x ){
//         /*k哈希值。把−109≤x≤109映射到1≤N≤105 。
//   Java中：取模运算，负数取模是负数，正数取模是正数。所以这里+N之后就一定
//    是一个整数，然后再模N，变回正数的模。
//    */
//        int  k = ( x % N + N ) % N;
//        // 元素直接存入单链表，头插进链表
//        e[idx] = x;
//        ne[idx] = h[k];
//        h[k] = idx++;
//    }
//
//    // 查找
//    public static boolean find( int x ){
//        int k = ( x % N + N ) % N ;
//        // 找到x在哈希表中的位置后，还要遍历这个位置开始的链表看看是否有x元素
//        for( int i = h[k] ; i != -1 ; i = ne[i] ){
//            if( e[i] == x ){
//                return true;
//            }
//        }
//        // 遍历结束即没有x元素
//        return false;
//    }
//}