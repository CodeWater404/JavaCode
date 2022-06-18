package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:27
 * @Function Description ：285.没有上司的舞会
 */
public class _285ADanceWithoutABoss {
    public static int N = 6010;
    public static int n , idx ;
    // 每个人的快乐指数
    public static int[] happy = new int[N];
    // 邻接表存储树
    public static int[] h = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    //状态方程,f[u][0/1]:所有从以u为根的子树中选择，并且不选/选u这个点的方案
    public static int[][] f = new int[N][2];
    // 因为题目没有告知根结点，所以还需要再求一下。也就是没有父结点的点
    public static boolean[] has_father = new boolean[N];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );

        // 读取初始的快乐指数  read直接读取的是一个字符
        for( int i = 1 ; i <= n ; i++ ){
            str = br.readLine().split(" ");
            happy[i] = Integer.parseInt( str[0] );

        }

        //初始化头结点
        Arrays.fill( h , -1 );
        //读入每一条边
        for( int i = 0 ; i < n - 1 ; i++ ){
            //b是a的父结点
            str = br.readLine().split(" ");
            int a = Integer.parseInt( str[0] ), b = Integer.parseInt( str[1] );
            has_father[a] = true;
            add( b , a );//添加a到b的一条边

        }

        // //求根结点
        int root = 1;
        while( has_father[root] == true ) root ++;

        dfs(root );

        System.out.println( Math.max( f[root][0] , f[root][1] ) );

    }

    public static void add( int a  , int b ){
        e[idx] = b ; ne[idx] = h[a] ; h[a] = idx++;
    }

    //递归求解每个状态
    public static void dfs( int u ){
        //选择u结点
        f[u][1] = happy[u];

        for( int i = h[u] ; i != -1 ; i = ne[i] ){
            //j表示u的每个儿子
            int j = e[i];
            dfs(j);

            f[u][0] += Math.max( f[j][0] , f[j][1] );
            f[u][1] += f[j][0];
        }

    }

}
