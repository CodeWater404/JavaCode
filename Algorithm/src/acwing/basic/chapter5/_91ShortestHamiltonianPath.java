package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:29
 * @Function Description ：91.最短Hamilton路径
 */
public class _91ShortestHamiltonianPath {
    public static int N = 20 , M = 1 << N ;
    public static int n ;
    // w[i][j]: ij两点之间的距离
    public static int[][] w = new int[N][N];
    // f[i][j]所有从0走到j,走过的所有点是i的所有路径（i要看成二进制）
    public static int[][] f = new int[M][N];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );


        for( int i = 0 ; i < n; i++ ){
            str = br.readLine().split(" ");
            for( int j = 0 ; j < n ; j++ ){
                w[i][j] = Integer.parseInt( str[j] );

            }

        }

        // 这里不能初始化0x3f，不然会过不了
        for( int i = 0 ; i < M ; i++ )  Arrays.fill( f[i] , 0x3f3f3f3f );
        // 初始在0号点，从0到0，走过的所有点只有0这个点，第0位上是1，其余为是0。
        f[1][0] = 0;

        //求每个状态
        for( int i = 0 ; i < 1 << n ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                // 从0 走到j， i里面一定得包含j
                if( (i >> j & 1 ) == 1 ){
                    // 枚举从哪个点转移过来的
                    for( int k = 0 ; k < n ; k++ ){
                        if( ( (i - ( 1 << j ) ) >> k & 1 ) == 1 ){
                            f[i][j] = Math.min(f[i][j] , f[i - (1 << j)][k] + w[k][j] );
                        }
                    }
                }
            }
        }

        System.out.println( f[(1 << n ) -1][n - 1] ) ;
    }

}
