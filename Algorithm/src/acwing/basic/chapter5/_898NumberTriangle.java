package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-14:17
 * @Function Description ：898.数字三角形
 */
public class _898NumberTriangle {
    public static int N = 510 , INF = 0x3f3f3f3f;
    // n层
    public static int n ;
    // a存储三角形的值   f[i][j]到达坐标i，j的一个最大路径数字和
    public static int[][] a = new int[N][N];
    public static int[][] f = new int[N][N];

    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );
        // 初始化
        for( int i = 1 ; i <= n ; i++ ){
            str = br.readLine().split(" ");
            for( int j = 1 ; j <= i ; j++ ){
                a[i][j] = Integer.parseInt( str[j - 1] );
            }
        }

        //为了不处理边界，先把所有f状态初始负无穷
        for( int i = 0 ; i <= n ; i++ ){
            // 边界的左上和右上，三角形的边上，所以要多处理一些边界
            for( int j = 0 ; j <= i + 1 ; j++ ){
                f[i][j] = -INF;
            }
        }

        //第一个点是确定的
        f[1][1] = a[1][1];
        //从第二行开始
        for( int i = 2 ; i <= n ; i++ ){
            for( int j = 1 ; j <= i ; j++ ){
                // 状态计算
                f[i][j] = Math.max( f[i - 1][j - 1] + a[i][j] , f[i - 1][j] + a[i][j] );
            }
        }

        int res = -INF;
        //遍历一遍最后一层，也就是选取从起点走到终点中的一个最大值
        for( int i = 1 ; i <= n ; i++ ){
            res = Math.max( res , f[n][i] );
        }


        System.out.println( res );

    }

}
