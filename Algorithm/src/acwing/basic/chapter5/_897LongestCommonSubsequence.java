package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:37
 * @Function Description ：897.最长公共子序列
 */
public class _897LongestCommonSubsequence {
    public static int N = 1010;
    // n：a字符串的长度   m：b字符串的长度
    public static int n, m ;
    // a字符串  b字符串   f[i][j]a的前i个字母和b的前j个字母的最长公共子序列
    public static char[] a = new char[N];
    public static char[] b = new char[N];
    public static int[][] f = new int[N][N];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );
        m = Integer.parseInt( str[1] );
        str[0] = br.readLine();
        for( int i = 1 ; i <= n ; i++ ) a[i] = str[0].charAt( i - 1) ;
        str[0] = br.readLine();
        for( int i = 1 ; i <= m ; i++ ) b[i] = str[0].charAt( i - 1)  ;

        //枚举所有的状态
        for( int i = 1 ; i <= n ; i++ ){
            for( int j = 1 ; j <= m ; j++ ){
                //如果都包含a[i]和b[j]，那么这两个的子序列一定要相等才能出现第三种情况。先求前两种
                f[i][j] = Math.max( f[i - 1][j] , f[i][j - 1] );
                // 加入第三种情况
                if( a[i] == b[j] ) f[i][j] = Math.max( f[i][j] , f[i - 1][j - 1] + 1) ;

            }
        }

        // a的前n个字母和b的前m个字母出现的最长公共子序列数量
        System.out.println( f[n][m] );
    }

}
