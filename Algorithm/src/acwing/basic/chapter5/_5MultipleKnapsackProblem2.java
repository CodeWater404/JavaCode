package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-14:13
 * @Function Description ：5.多重背包
 */
public class _5MultipleKnapsackProblem2 {
    //最大有1000种物品，每种物品最多可以分成log2000=11组（向上取整），所以最大11000。M体积
    public static int N = 12000 ,  M = 2010;
    // n种物品   背包的体积为m
    public static int n  , m ;
    // v体积 w价值  f【j】对应体积为j能选的最大价值
    public static int[] v = new int[N];
    public static int[] w = new int[N];
    public static int[] f = new int[N];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );
        m = Integer.parseInt( str[1] );
        // cnt存储所有新的物品的编号，也就是n种物品一共分成了cnt组
        int cnt = 0;

        for( int i = 1 ; i <= n ; i++ ){
            str = br.readLine().split(" ");
            // a体积   b价值   s当前物品的总量
            int a = Integer.parseInt(str[0]) , b = Integer.parseInt( str[1] ) ,
                    s = Integer.parseInt( str[2] );
            // 当前物品数量从1开始分
            int k = 1 ;
            //分下来的数量小于这个物品的总数，继续拆分
            while( k <= s ){
                //每次把k个物品分成一组，cnt编号++
                cnt++;
                // 当前组的体积  和价值
                v[cnt] = a * k;
                w[cnt] = b * k;
                // 物品总数对应减少 ， k变大
                s -= k;
                k *= 2;
            }
            if( s > 0 ){ //分到最后，s还有一些，但是凑不成2的次方了
                cnt++;
                v[cnt] = s * a;
                w[cnt] = s * b ;
            }
        }

        //n更新成cnt，然后做一遍01背包问题
        n = cnt;
        for( int i = 1 ; i <= n ; i++ ){
            for( int j = m ; j >= v[i] ; j-- ){
                f[j] = Math.max( f[j] , f[j - v[i]] + w[i] );
            }
        }

        System.out.println( f[m] );
    }

}
