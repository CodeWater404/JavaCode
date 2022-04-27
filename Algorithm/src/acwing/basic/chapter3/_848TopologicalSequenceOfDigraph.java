package acwing.basic.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-04-27-14:44
 * @Function Description ：848有向图的拓扑序列
 * 给定一个 n 个点 m 条边的有向图，点的编号是 1 到 n，图中可能存在重边和自环。
 *
 * 请输出任意一个该有向图的拓扑序列，如果拓扑序列不存在，则输出 −1。
 *
 * 若一个由图中所有点构成的序列 A 满足：对于图中的每条边 (x,y)，x 在 A 中都出现在 y 之前，则称 A 是该图的一个拓扑序列。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 接下来 m 行，每行包含两个整数 x 和 y，表示存在一条从点 x 到点 y 的有向边 (x,y)。
 *
 * 输出格式
 * 共一行，如果存在拓扑序列，则输出任意一个合法的拓扑序列即可。
 *
 * 否则输出 −1。
 *
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 3 3
 * 1 2
 * 2 3
 * 1 3
 * 输出样例：
 * 1 2 3
 */
public class _848TopologicalSequenceOfDigraph {
    public static int N = 100010;
    // 邻接表存储图  h头结点数组   e存储边的另外一端结点  ne存储该点连接的下一个结点
    public static int[] h = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    // idx链表当前使用的下标  n实际输入的顶点数  m实际输入的边数 
    public static int idx = 0 , n , m ;
    // q数组模拟的队列  d数组存储每个结点的入度是多少
    public static int[] q = new int[N];
    public static int[] d = new int[N];

    public static void main( String[] args ) throws IOException {
        
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]) ; m = Integer.parseInt(str[1]);
        // 初始化头结点数组-1
        Arrays.fill( h , -1 );
        // 读取输入的数据，构建图
        for( int i = 0 ; i < m ; i++ ){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]) , b = Integer.parseInt(str[1]);
            add( a , b );
            // a到b有一条边， 对应的b结点的入度就加1
            d[b]++;
        }

        // 没有拓扑排序
        if( !topSort() ) System.out.println( "-1" );
        else{
            // 队列中存储的元素顺序就是拓扑排序的顺序
            for( int i = 0 ; i < n ; i++ ) System.out.print( q[i] + " " );
            System.out.println();
        }
    }

    // 构建a到b点的一条有向边（头插）
    public static void add( int a , int b ){
        e[idx] = b ; ne[idx] = h[a] ; h[a] = idx++;
    }

    // 拓扑排序
    public static boolean topSort(){
        // hh队头指针 tt队尾指针
        int hh = 0 , tt = -1;
        // 遍历所有的结点，把入度为0的结点入队
        for( int i = 1 ; i <= n ; i++ ){
            if( d[i] == 0 ){
                q[++tt] = i;
            }
        }
        // 队不空
        while( hh <= tt ){
            // 取出队头，同时删除队头（队头指针后移）
            int t = q[hh++];
            // 遍历该结点所在的链表。也就是遍历它所可以到达的另外一些结点
            for( int i = h[t] ; i != -1 ; i = ne[i] ){
                // j暂存t可以到达的结点
                int j = e[i];
                // j结点入度为0，入队
                if( --d[j] == 0 ){
                    q[++tt] = j;
                }
            }
        }
        // 最后如果队尾指针正好到达第n-1（下标从开始的）个结点，说明有拓扑序列
        return tt == n - 1;
    }
}
