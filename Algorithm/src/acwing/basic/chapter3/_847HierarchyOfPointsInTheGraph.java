package acwing.basic.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ： CodeWater
 * @create ：2022-04-26-14:49
 * @Function Description ：图中点的层次（）bfs
 * 给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环。
 *
 * 所有边的长度都是 1，点的编号为 1∼n。
 *
 * 请你求出 1 号点到 n 号点的最短距离，如果从 1 号点无法走到 n 号点，输出 −1。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 接下来 m 行，每行包含两个整数 a 和 b，表示存在一条从 a 走到 b 的长度为 1 的边。
 *
 * 输出格式
 * 输出一个整数，表示 1 号点到 n 号点的最短距离。
 *
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 4 5
 * 1 2
 * 2 3
 * 3 4
 * 1 3
 * 1 4
 * 输出样例：
 * 1
 */
public class _847HierarchyOfPointsInTheGraph {
     /*
重边：a到b有两条边
自环：自己指向自己
权重都为1，所以可用宽搜求最短距离
初始，每个结点都以自己为单链表的头，共有m个单链表，然后不断头插可以到达的点
*/

    public static int N = 100010;
    // （数组模拟）领接表存储图， h头结点数组  e存储边的另外一端结点
    public static int[] h = new int[N];
    public static int[] e = new int[N];
    // ne存储下一个结点   idx链表当前使用到的下标
    public static int[] ne = new int[N];
    public static int idx  , n , m ;
    // d距离数组,记录从1号结点到n号点的距离(存储值),下标是达到某个结点
    public static int[] d = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] ) ; m = Integer.parseInt( str[1] );
        // 初始化头结点数组 (有个简单写法Arrays.fill(h , -1) )
        for( int i = 0 ; i < N ; i++ )
            h[i] = -1;
        // 读取输入m条边,构建图
        for( int i = 0; i < m ; i++ ){
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);

            add( a , b );
        }
        // 输出答案
        System.out.println( bfs() );

    }

    // 实现添加a结点到b结点的一条有向边(头插)
    public static void add( int a , int b ){
        e[idx] = b ; ne[idx] = h[a] ; h[a] = idx++;
    }

    // 深搜
    public static int bfs(){
        // 初始化头结点数组
        for( int i = 0 ; i < N ; i++ ){
            d[i] = -1;
        }
        // 1号点到自己距离是0，把1号点入队
        Queue<Integer> q = new LinkedList<>();
        d[1] = 0 ;
        q.offer(1);

        // 队列不空
        while( !q.isEmpty() ){
            // 取出队头，同时删除
            int t = q.poll();
            // 遍历t结点相连接的结点
            for( int i = h[t] ; i != -1 ; i = ne[i] ){
                // j暂存t相邻的结点
                int j = e[i];
                // j没有遍历过
                if( d[j] == -1 ){
                    // 更新添加到j的距离
                    d[j] = d[t] + 1;
                    // j结点入队
                    q.offer(j);
                }
            }
        }
        // 宽搜结束，返回到n的距离
        return d[n];
    }
}
