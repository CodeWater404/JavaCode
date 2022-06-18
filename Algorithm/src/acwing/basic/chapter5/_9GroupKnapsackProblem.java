package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-14:15
 * @Function Description ：9.分组背包
 */
public class _9GroupKnapsackProblem {
    public static int N = 110;
    //n组物品  背包体积m
    public static int n , m ;
    // v[i][j]第i组内的第j个物品体积   w[i][j]第i组内的第j个物品的价值
    public static int[][] v = new int[N][N];
    public static int[][] w = new int[N][N];
    // s[i]对应每组中有多少个物品
    public static int[] s = new int[N];
    // f[j]对应背包体积j能选的最大价值
    public static int[] f = new int[N];

    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );
        m = Integer.parseInt( str[1] );
        for( int i = 1 ; i <= n ; i++ ){
            str = br.readLine().split(" ");
            s[i] = Integer.parseInt( str[0] );
            for( int j = 0; j < s[i] ; j++ ){
                str = br.readLine().split(" ");
                v[i][j] = Integer.parseInt( str[0] );
                w[i][j] = Integer.parseInt( str[1] );
            }
        }

        for( int i = 1 ; i <= n ; i++ ){
            //从大到小枚举体积
            for( int j = m ; j >= 0 ; j-- ){
                //枚举一组内k个物品
                for( int k = 0 ; k <= s[i] ; k++ ){
                    // 只有这个物品体积小于等于j，才会选择
                    if( v[i][k] <= j )
                        f[j] = Math.max( f[j] , f[ j - v[i][k] ] + w[i][k] );
                }
            }
        }

        System.out.println( f[m] );
    }

}
