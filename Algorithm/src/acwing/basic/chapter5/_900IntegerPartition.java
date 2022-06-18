package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:32
 * @Function Description ：900.整数划分
 */
public class _900IntegerPartition {
    // java中1e9是double类型
    public static int N = 1010 , M = (int) (1e9 + 7);
    // 整数n
    public static int n;
    // f[j]整数j的划分数量
    public static int[] f = new int[N];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) ) ;
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );
        // 一个数都不选，总和是0 ， 是一种方案
        f[0] = 1;
        for( int i = 1 ; i <= n; i++ ){
            for( int j = i ; j <= n ; j++ ){
                // 推算处的状态转义方程，看图
                f[j] = (f[j] + f[j - i] ) % M;
            }
        }

        System.out.println( f[n] );
    }

    
//    method2
    /**
     * // java中1e9是double类型
     *     public static int N = 1010 , M = (int) (1e9 + 7);
     *     // 整数n
     *     public static int n;
     *     // f[i][j]和是i，恰好表示成j个数的情况
     *     public static int[][] f = new int[N][N];
     *
     *     public static void main( String[] args ) throws IOException {
     *         BufferedReader br = new BufferedReader( new InputStreamReader(System.in) ) ;
     *         String[] str = br.readLine().split(" ");
     *         n = Integer.parseInt( str[0] );
     *         // 边界情况：总和是0 ，选了0个， 是一种方案
     *         f[0][0] = 1;
     *         for( int i = 1 ; i <= n; i++ ){
     *             // i最多表示i个数的和
     *             for( int j = 1 ; j <= i ; j++ ){
     *                 // 推算出的状态转义方程，看图
     *                 f[i][j] = (f[i - 1][j - 1] + f[i - j][j] ) % M ;
     *             }
     *         }
     *
     *         int res = 0 ;
     *         //所有方案数相加
     *         for( int i = 1 ; i <= n ; i++ ) res = (res + f[n][i] ) % M;
     *
     *         System.out.println( res );
     *     }
     *
     * 作者：CodeWater
     * 链接：https://www.acwing.com/activity/content/code/content/3573435/
     * 来源：AcWing
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
