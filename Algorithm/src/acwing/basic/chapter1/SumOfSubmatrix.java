package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-16-10:43
 * @Function Description ：
 * 子矩阵的和（前缀和的二维应用）
 */
public class SumOfSubmatrix {
    public static int N = 1010;
    public static int n , m , q;
    public static int[][] a = new int[N][N];
    public static int[][] s = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in )) ;
        String[] str = br.readLine().split( " " );
        n = Integer.parseInt(str[0]) ;
        m = Integer.parseInt( str[1] );
        q = Integer.parseInt( str[2] );

        for( int i = 1 ; i <= n ; i++ ){
            str = br.readLine().split( " " );
            for( int j = 1 ; j <= m ; j++ ){
                // 一行有j个数，for下标从1开始，str从0开始
                a[i][j] = Integer.parseInt( str[j - 1] );
                s[i][j] = s[i][j - 1] + s[i - 1][j] + a[i][j] - s[i - 1][j - 1];
            }
        }

        while( q-- > 0 ){
            str = br.readLine().split( " " );
            int x1 = Integer.parseInt( str[0] ), y1 = Integer.parseInt( str[1] );
            int x2 = Integer.parseInt( str[2] ) , y2 = Integer.parseInt( str[3] );
            int ans = s[x2][y2] - s[x2][y1 -1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1];
            System.out.println( ans );
        }

    }
}
