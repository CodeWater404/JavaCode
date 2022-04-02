package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-04-02-12:56
 * @Function Description ：连通块中的数量（并查集）
 * 给定一个包含 n 个点（编号为 1∼n）的无向图，初始时图中没有边。
 *
 * 现在要进行 m 个操作，操作共有三种：
 *
 * C a b，在点 a 和点 b 之间连一条边，a 和 b 可能相等；
 * Q1 a b，询问点 a 和点 b 是否在同一个连通块中，a 和 b 可能相等；
 * Q2 a，询问点 a 所在连通块中点的数量；
 * 输入格式
 * 第一行输入整数 n 和 m。
 *
 * 接下来 m 行，每行包含一个操作指令，指令为 C a b，Q1 a b 或 Q2 a 中的一种。
 *
 * 输出格式
 * 对于每个询问指令 Q1 a b，如果 a 和 b 在同一个连通块中，则输出 Yes，否则输出 No。
 *
 * 对于每个询问指令 Q2 a，输出一个整数表示点 a 所在连通块中点的数量
 *
 * 每个结果占一行。
 *
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 5 5
 * C 1 2
 * Q1 1 2
 * Q2 1
 * C 2 5
 * Q2 5
 * 输出样例：
 * Yes
 * 2
 * 3
 */
public class _837NumberOfConnectedBlocks {
    public static int N = 100010;
    //并查集
    public static int[] p = new int[N];
    // cnt记录每个集合的数量
    public static int[] cnt = new int[N];
    public static int n , m ;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) ) ;
        String[] str = br.readLine().split( " " );
        n = Integer.parseInt( str[0] ) ; m = Integer.parseInt( str[1] );
        for( int i = 1 ; i <= n ; i++ ){
            // 并查集初始情况，每个数自己是一个集合；每个集合中个数只有一个
            p[i] = i;
            cnt[i] = 1;
        }

        while( m-- > 0 ){
            str = br.readLine().split( " " );
            int a , b ;
            if( str[0].equals( "C" ) ){
                // 合并
                a = Integer.parseInt( str[1] ) ; b = Integer.parseInt( str[2] );
                if( find(a) == find(b) ) continue;
                // 把a合并到b中，同时更新b集合的数量
                cnt[find(b)] += cnt[find(a)];
                p[find(a)] = find(b);
            }else if( str[0].equals( "Q1" ) ){
                // 查找两个集合是否在一个集合中
                a = Integer.parseInt( str[1] ) ; b = Integer.parseInt( str[2] );
                if( find(a) == find(b) ) System.out.println( "Yes" );
                else System.out.println( "No" );
            }else{
                // 查找某个集合中的数量，注意要输出cnt【a的集合，也就是a所在的根结点】
                a = Integer.parseInt( str[1] );
                System.out.println( cnt[find(a)] );
            }
        }
    }

    // 查找一个数属于哪个集合，路径压缩：一旦查找到其根结点这条路上所有都指向根
    public static int find( int x ){
        if( p[x] != x ) p[x] = find( p[x] );
        return p[x];
    }
}
