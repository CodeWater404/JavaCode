package acwing.interview.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-04-25-12:59
 * @Function Description ：蛇形矩阵
 * 输入两个整数 n 和 m，输出一个 n 行 m 列的矩阵，将数字 1 到 n×m 按照回字蛇形填充至矩阵中。
 *
 * 具体矩阵形式可参考样例。
 *
 * 输入格式
 * 输入共一行，包含两个整数 n 和 m。
 *
 * 输出格式
 * 输出满足要求的矩阵。
 *
 * 矩阵占 n 行，每行包含 m 个空格隔开的整数。
 *
 * 数据范围
 * 1≤n,m≤100
 * 输入样例：
 * 3 3
 * 输出样例：
 * 1 2 3
 * 8 9 4
 * 7 6 5
 */
public class _765SerpentineMatrix {
    public static int N = 110;
    // 答案数组
    public static int[][] ans = new int[N][N];
    public static int n , m;

    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] ); m = Integer.parseInt( str[1] );
        // xy答案数组中要填入的坐标 ，d标记坐标的转向，配合dxdy偏移量使用
        int x = 0 , y = 0 , d = 1;
        // 上右下左四个顺时针方向。dxdy一一对应，要转向是d就加
        int[] dx = {-1 , 0 , 1 , 0 } ;
        int[] dy = {0 , 1 , 0 , -1 };
        // i是要填入的数字，从1开始
        for( int i = 1 ; i <= n * m ; i++ ){
            // 先填入数字
            ans[x][y] = i;
            // ab存储下一步的坐标
            int a = x + dx[d] , b = y + dy[d];
            // ab走出范围或者走到了已经有数字的地方
            if( a < 0 || a >= n || b < 0 || b >= m || ans[a][b] != 0 ){
                // d转向90度
                d = (d + 1) % 4;
                // 更新ab坐标
                a = x + dx[d] ;
                b = y + dy[d] ;
            }
            // 更新xy，方便下一次填入数组
            x = a ; y = b;
        }

        // 输出
        for( int i = 0 ; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                System.out.print( ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
