package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:34
 * @Function Description ：282.石子合并
 */
public class _282StoneMerging {
    public static int N = 310;
    public static int n ;
    //前缀和
    public static int[] s = new int[N];
    //f[i][j]从第i堆到第j堆石子需要合并的代价
    public static int[][] f = new int[N][N];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );
        str = br.readLine().split(" ");
        for( int i = 1 ; i <= n ; i++ ) s[i] = Integer.parseInt( str[i - 1] );

        //求前缀和
        for( int i = 1 ; i <= n ; i++ ) s[i] += s[i - 1];

        //按照长度从小到大来枚举 ， 边界情况区间长度为1的时候不需要代价，所以从2开始
        for( int len = 2 ; len <= n ; len++ ){
            for( int i = 1 ; i + len - 1 <= n ; i++ ){
                //l左半边  r右半边
                int l = i , r = i + len -1 ;
                //初始化状态
                f[l][r] = (int) 1e8;
                //枚举区间
                for( int k = l ; k < r ; k++ ){
                    // 状态转义方程，不理解的看图解
                    f[l][r] = Math.min( f[l][r] , f[l][k] + f[k + 1][r] + s[r] - s[l - 1] );
                }
            }
        }

        //输出将第一堆到第n堆合并的代价
        System.out.println( f[1][n] );
    }

}
