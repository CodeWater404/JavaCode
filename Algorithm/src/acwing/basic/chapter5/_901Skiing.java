package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:25
 * @Function Description ：901.滑雪
 */
public class _901Skiing {
    public static int N = 310;
    public static int n , m ;
    //h[i][j]这个点的高度是多少；f[i][j]这个点可走的路径的最大长度
    public static int[][] h = new int[N][N];
    public static int[][] f = new int[N][N];
    // 偏移量表示4个方向:上右下左
    public static int[] dx = {-1 , 0 , 1 , 0 } , dy = {0 , 1 , 0 , -1};


    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] ); m = Integer.parseInt( str[1] );

        for( int i = 1; i <= n ; i++ ){
            str = br.readLine().split(" ");
            for( int j = 1 ; j <= m ; j++ ){
                h[i][j] = Integer.parseInt( str[j - 1] );
            }
        }

        //算每个状态的套路：先初始化每个状态，表示没有被算过
        for( int i = 0 ; i < N ; i++ )
            Arrays.fill( f[i] , -1 );

        //最大值
        int res = 0 ;
        // 枚举从每个点除法
        for( int i = 1 ; i <= n ; i++ ){
            for( int j = 1 ; j <= m ; j++ ){
                res = Math.max( res , dp( i , j ) );
            }
        }

        System.out.println( res );
    }

    //返回的是(x,y)点能走的最大路径
    public static int dp( int x , int y ){
        //xy位置已经计算过了
        if( f[x][y] != -1 ) return f[x][y];

        //初始化,xy位置最少走当前这个格子
        f[x][y] = 1;
        // 枚举4个方向
        for( int i = 0 ; i < 4 ; i++ ){
            int a = x + dx[i] , b = y + dy[i] ;
            //在边界内并且下一个点的高度比当前高度小
            if( a >= 1 && a <= n && b >= 1 && b <= m && h[a][b] < h[x][y] ){
                //当前点是xy，回退到上一个点ab然后加上到xy的1的距离从而算出xy最大的状态
                f[x][y] = Math.max( f[x][y] , dp(a , b ) + 1 );
            }
        }
        return f[x][y];
    }

}
