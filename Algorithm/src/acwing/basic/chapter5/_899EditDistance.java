package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:35
 * @Function Description ：899.编辑距离
 */
public class _899EditDistance {
    // 字符串最大N长度    最大M次询问
    public static int N = 15 , M = 1010;
    // n个字符串  m次询问
    public static int n , m ;
    // f[i][j]a的前i个字母和b的前j个字母最少的操作次数    ch[i]存储第i个字符串
    public static int[][] f = new int[N][N];
    public static String[] ch = new String[M];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        n = Integer.parseInt( str[0] );
        m = Integer.parseInt( str[1] );
        for( int i = 0 ; i < n ; i++ )  ch[i] = br.readLine();

        // m次询问
        while( m-- > 0 ){
            str = br.readLine().split(" ");
            String s = str[0];
            int limit = Integer.parseInt( str[1] );
            // res答案
            int res = 0 ;
            // 遍历编辑距离和limit
            for(int i = 0 ; i < n ; i++ ){
                if( edit_distance( ch[i] , s ) <= limit ) {
                    res++;
                }
            }
            // 输出每次询问的答案
            System.out.println( res );
        }

    }

    // 这个就是902的最短编辑距离
    public static int edit_distance( String a , String b ){
        // 求两个字符串的长度
        int la = a.length() , lb = b.length();

        // 初始化边界
        for( int i = 0 ; i <= lb ; i++ ) f[0][i] = i;
        for( int i = 0 ; i <= la ; i++ ) f[i][0] = i;

        for( int i = 1 ; i <= la ; i++ ){
            for( int j = 1 ; j <= lb ; j++ ){
                // 前两种情况直接求
                f[i][j] = Math.min( f[i - 1][j] + 1 , f[i][j - 1] + 1);
                // 第三种情况需要判断是否要改
                f[i][j] = Math.min( f[i][j] , f[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1 ) );
            }
        }

        return f[la][lb];
    }

}
