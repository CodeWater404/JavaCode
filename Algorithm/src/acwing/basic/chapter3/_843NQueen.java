package acwing.basic.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-04-19-14:53
 * @Function Description ：843.n皇后
 *
n−皇后问题是指将 n 个皇后放在 n×n 的国际象棋棋盘上，使得皇后不能相互攻击到，即任意两个皇后都不能处于同一行、同一列或同一斜线上。

现在给定整数 n，请你输出所有的满足条件的棋子摆法。

输入格式
共一行，包含整数 n。

输出格式
每个解决方案占 n 行，每行输出一个长度为 n 的字符串，用来表示完整的棋盘状态。

其中 . 表示某一个位置的方格状态为空，Q 表示某一个位置的方格上摆着皇后。

每个方案输出完成后，输出一个空行。

注意：行末不能有多余空格。

输出方案的顺序任意，只要不重复且没有遗漏即可。

数据范围
1≤n≤9
输入样例：
4
输出样例：
.Q..
...Q
Q...
..Q.

..Q.
Q...
...Q
.Q..

 */
public class _843NQueen {
    //数据范围开两倍，因为对角线上的数量是2倍的n
    public static int N = 20;
    //n行n列h个皇后。g数组记录n皇后的一种摆放方案
    public static char[][] g = new char[N][N];
    //row标记一行上能不能放置，col标记一列上能不能放置 ，
    public static boolean[] col = new boolean[N];
    public static boolean[] row = new boolean[N];
    // dg数组标记斜线上能不能放置,udg是反对角线，同理
    public static boolean[] dg = new boolean[N];
    public static boolean[] udg = new boolean[N];
    public static int n ;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        n = Integer.parseInt(br.readLine());
        // 初始化
        for( int i = 0 ; i < n ; i++ )
            for( int j = 0 ; j < n ; j++ )
                g[i][j] =  '.';
        // 深搜
        dfs( 0 , 0 , 0 );

    }

    //x ：g数组上纵坐标扫描标记一整行 ， y：g数组上横坐标扫描标记一整列，s：皇后个数
    // 这种搜索方式是x，y坐标放到参数里面了，不用for遍历
    public static void dfs( int x , int y , int s ){
        // 到达一行的最后一个位置
        if( y == n ){
            // 重置扫描下一行
            y = 0 ;
            x ++ ;
        }
        // 扫描到最后一行（层）
        if( x == n ){
            // 皇后个数放满，输出一种方案
            if( s == n ){
                for( int i = 0 ; i < n ; i++ ){
                    for( int j = 0 ; j < n ; j++ ){
                        System.out.print( g[i][j] );
                    }
                    System.out.println();
                }
                System.out.println( );
            }
            return;
        }
        // 第一种当前层不放皇后，s个数不加
        dfs( x , y + 1 , s );
        // 如果本行本列对角线反对角线上没有皇后，该位置就可以放置
        if( !row[x] && !col[y] && !dg[x + y] && !udg[x - y + n] ){
            // 放置皇后，同时标记
            g[x][y] = 'Q';
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = true;
            // 继续下一层的搜索，皇后个数加1
            dfs( x , y + 1  , s + 1 );
            // 回溯到本层的时候标记重置
            row[x] = col[y] = dg[x + y] = udg[x - y + n] = false;
            g[x][y] = '.';
        }

    }
}
