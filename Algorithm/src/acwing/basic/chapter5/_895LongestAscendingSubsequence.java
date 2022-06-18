package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-14:18
 * @Function Description ：895.最长上升子序列
 */
public class _895LongestAscendingSubsequence {
    public static int N = 1010;
    // n个数
    public static int n;
    public static int[] a = new int[N];
    // f[i]以 第i个数结尾的最长子序列
    public static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );
        str = br.readLine().split(" ");
        for( int i = 1 ; i <= n ; i++ ){
            a[i] = Integer.parseInt( str[i - 1] );
        }

        // 从前往后计算每一个状态
        for( int i = 1 ; i <= n ; i++ ){
            //极端情况，只有自己
            f[i] = 1;
            // 子序列长度为2 ：枚举上一个数是哪个
            for( int j = 1 ; j < i ; j++ ){
                // 前面的数必须小于当前第i个数结尾的
                if( a[j] < a[i] ){
                    // 计算状态
                    f[i] = Math.max( f[i] , f[j] + 1 );
                }
            }
        }

        int res = 0 ;
        // 枚举所有的点
        for( int i = 1 ; i <= n ; i++ ) res = Math.max( res , f[i] );
        System.out.println( res );
    }

}
