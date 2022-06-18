package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:36
 * @Function Description ：902.最短编辑距离
 */
public class _902MinimumEditingDistance {
    public static int N = 1010;
    // n：a的长度  m：b的长度   a：字符串 b:字符串   
    public static int n , m;
    public static char[] a = new char[N];
    public static char[] b = new char[N];
    // f[i][j]:a的前i个字母和b的前j个字母相等需要的最少操作次数
    public static int[][] f = new int[N][N];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String str ;
        n = Integer.parseInt( br.readLine().split(" ")[0] );  //n和m那里后面有个空格。。。。
        str = br.readLine();
        for( int i = 1 ; i <= n ; i++ ) a[i] = str.charAt( i - 1);
        m = Integer.parseInt( br.readLine().split(" ")[0] ) ;
        str = br.readLine();
        for( int i = 1 ; i <= m ; i++ ) b[i] = str.charAt( i - 1);

        /**初始化边界情况
         * 1. a的第0个字母和b的第i个字母匹配，只能对A用添加操作，b有i个就是i次
         * 2. a的第i个字母和b的第0个字母匹配，只能对A用删除操作，a有i个就是i次
         */
        for( int i = 0 ; i <= m ; i++ ) f[0][i] = i;
        for( int i = 0 ; i <= n ; i++ ) f[i][0] = i;

        //枚举所有的状态
        for( int i = 1 ; i <= n ; i++ ){
            for( int j = 1 ; j <= m ; j++ ){
                // 前两种情况可以直接算
                f[i][j] = Math.min( f[i - 1][j] + 1 , f[i][j - 1] + 1 );
                // 第三种情况需要判断是否相等，从而进行是否+1操作
                if( a[i] == b[j] ) f[i][j] = Math.min( f[i][j] , f[i - 1][j - 1] );
                else f[i][j] = Math.min( f[i][j] , f[i - 1][j - 1] + 1); //不等需要修改，即+1
            }
        }

        System.out.println( f[n][m] );
    }

}
