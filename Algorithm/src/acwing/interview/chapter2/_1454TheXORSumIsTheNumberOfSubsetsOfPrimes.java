package acwing.interview.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-17:17
 * @Function Description ：异或和是质数的子集数
 */
public class _1454TheXORSumIsTheNumberOfSubsetsOfPrimes {
    // 最多N个数   最大的异或和M    n实际数字个数
    public static int N = 5010 , M = 8192 , n ;
    public static int MOD = (int)1e9 + 7;
    // a记录正整数   f[i][j]只考虑前i个数异或和是j的方案数
    public static int[] a = new int[N];
    public static int[][] f = new int[2][M];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );
        str = br.readLine().split(" ");
        for( int i = 1 ; i <= n ; i++ ){
            a[i] = Integer.parseInt(str[i - 1]);
        }

        //有0个数的时候能够异或出0的方案是1
        f[0][0] = 1;
        // 枚举所有的状态
        for( int i = 1 ; i <= n ; i++ ){
            for( int j = 0 ; j < M ; j++ ){
                // 第一维加上&1，就可以实现把偶数映射成0，奇数映射成1
                f[i & 1][j] = f[i - 1 & 1][j];
                // 第二种情况需要判断一下，因为j异或a[i]有可能大于等于M，只有小于的时候下标才正确
                // 在Java中^优先级小于<，所以要加个括号
                if( (j ^ a[i]) < M ) f[i & 1][j] = ( f[i & 1][j] + f[i - 1 & 1][j ^ a[i] ]) % MOD;
            }
        }

        // 求一下所有质数的和
        int res = 0 ;
        // 质数从2开始，0、1不算
        for( int i = 2 ; i < M ; i++ ){
            if( is_prime(i) ){
                res = (res + f[n & 1][i]) % MOD;
            }
        }

        System.out.println( res );
    }

    // 试除法判断质数
    public static boolean is_prime( int x ){
        for( int i = 2 ; i * i <= x ; i++ ){
            if( x % i == 0 ){
                return false;
            }
        }

        return true;
    }
}
