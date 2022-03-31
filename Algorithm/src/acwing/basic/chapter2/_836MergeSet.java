package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-31-23:10
 * @Function Description ：合并集合（并查集）
 * 一共有 n 个数，编号是 1∼n，最开始每个数各自在一个集合中。
 *
 * 现在要进行 m 个操作，操作共有两种：
 *
 * M a b，将编号为 a 和 b 的两个数所在的集合合并，如果两个数已经在同一个集合中，则忽略这个操作；
 * Q a b，询问编号为 a 和 b 的两个数是否在同一个集合中；
 * 输入格式
 * 第一行输入整数 n 和 m。
 *
 * 接下来 m 行，每行包含一个操作指令，指令为 M a b 或 Q a b 中的一种。
 *
 * 输出格式
 * 对于每个询问指令 Q a b，都要输出一个结果，如果 a 和 b 在同一集合内，则输出 Yes，否则输出 No。
 *
 * 每个结果占一行。
 *
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 4 5
 * M 1 2
 * M 3 4
 * Q 1 2
 * Q 1 3
 * Q 3 4
 * 输出样例：
 * Yes
 * No
 * Yes
 */
public class _836MergeSet {
    public static int N = 100010;
    // p数组存储的下标的父亲是谁，p[1] =2，值1的父亲就是2，属于2这个集合（具体看最终的根结点）
    public static int[] p = new int[N];
    public static int n , m;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        n = Integer.parseInt( str[0] );
        m = Integer.parseInt( str[1] );
        //一开始，每个数自己就是一个集合
        for( int i = 1 ; i <= n ; i++ ) p[i] = i;
        while( m-- > 0 ){
            str = br.readLine().split( " " );
            String op = str[0];
            int a = Integer.parseInt( str[1] )  ;
            int b = Integer.parseInt( str[2] );
            // 合并集合：把a的父结点设置成b的集合编号，也就实现了合并集合
            if( op.equals( "M" ) ) p[find(a)] = find(b);
            else{
                // 如果两个集合的最终集合编号不是同一个数，那么他们就不是在一个集合中
                if( find(a) != find(b) ) System.out.println( "No" );
                else System.out.println( "Yes" );

            }
        }

    }

    // 查找某个数属于哪个集合
    public static int find( int x ){
        // 一个数x的集合编号不是自己，说明就有其父结点，递归查找
        if( p[x] != x ) p[x] = find( p[x] );
        // 最终返回这个集合编号，也就是这个集合的根结点
        return p[x];
    }
}
