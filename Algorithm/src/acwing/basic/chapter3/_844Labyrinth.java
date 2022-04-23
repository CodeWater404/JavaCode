package acwing.basic.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ： CodeWater
 * @create ：2022-04-23-16:57
 * @Function Description ：844走迷宫
 * 给定一个 n×m 的二维整数数组，用来表示一个迷宫，数组中只包含 0 或 1，其中 0 表示可以走的路，1 表示不可通过的墙壁。
 *
 * 最初，有一个人位于左上角 (1,1) 处，已知该人每次可以向上、下、左、右任意一个方向移动一个位置。
 *
 * 请问，该人从左上角移动至右下角 (n,m) 处，至少需要移动多少次。
 *
 * 数据保证 (1,1) 处和 (n,m) 处的数字为 0，且一定至少存在一条通路。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 接下来 n 行，每行包含 m 个整数（0 或 1），表示完整的二维数组迷宫。
 *
 * 输出格式
 * 输出一个整数，表示从左上角移动至右下角的最少移动次数。
 *
 * 数据范围
 * 1≤n,m≤100
 * 输入样例：
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 输出样例：
 * 8
 */
public class _844Labyrinth {
    public static int N = 110;
    // g存储迷宫  d存储走出迷宫的每一步距离
    public static int[][] g = new int[N][N];
    public static int[][] d = new int[N][N];
    public static int n , m ;

    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) ) ;
        String[] str = br.readLine().split( " ");
        n = Integer.parseInt( str[0] ); m = Integer.parseInt( str[1] );
        for( int i = 0 ; i < n ; i++ ){
            str = br.readLine().split(" ");
            for( int j = 0 ; j < m ; j++ ){
                g[i][j] = Integer.parseInt( str[j] );
            }
        }

        System.out.println( bfs() ) ;
    }

    // 宽搜
    public static int bfs(){
        Queue<PII> q = new LinkedList<>();
        // 初始化距离数组，-1不可达
        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < d[i].length ; j++ ){
                d[i][j]  = -1;
            }
        }
        // 起点设置可达  ， 入队
        d[0][0] = 0 ;
        q.offer(new PII(0 , 0 ) );

        // 定义左下右上四个方向的xy偏移量，一一对应
        int[] dx = {-1, 0 , 1, 0 } ; /*int[] dy = { 0 , -1 , 0 , 1 };*/
        int[] dy = { 0 , 1 , 0 , -1 };
// 队列不空
        while( !q.isEmpty() ){
            // poll取出队头并删除元素；peek取出队头不删除
            PII t = q.poll();
            // 从当前坐标依次遍历四个方向
            for( int i = 0 ; i < 4 ; i++ ){
                // xy记录下一步要走的坐标
                int x = t.first + dx[i] , y = t.second + dy[i];
                // 判断下一步的坐标是否可达
                if( x >= 0 && x < n && y >= 0 && y < m && g[x][y] == 0 && d[x][y] == -1 ){
                    // 可达， 更新到达xy距离； 同时把xy入队
                    d[x][y] = d[t.first][t.second] + 1;
                    q.offer( new PII( x , y ) );
                }
            }
        }
        // 返回走出迷宫的步数
        return d[n - 1][m - 1];
    }
    
}

class PII{
    int first ;
    int second ;

    public PII( int first , int second ){
        this.first = first ;
        this.second = second;
    }
}