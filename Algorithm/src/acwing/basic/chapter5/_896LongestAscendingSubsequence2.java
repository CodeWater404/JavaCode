package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:24
 * @Function Description ：896.最长上升子序列2
 */
public class _896LongestAscendingSubsequence2 {
    public static int N = 100010;
    public static int n;
    // a存储每一个值   q[i]子序列长度为i的结尾值是多少 
    public static int[] a = new int[N];
    public static int[] q = new int[N];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );
        str = br.readLine().split(" ");
        for( int i = 0 ; i < n ; i++ ){
            a[i] = Integer.parseInt( str[i] );
        }

        // len存储当前的一个子序列的最大长度，即q中元素个数。初始0
        int len = 0 ;
        // 保证小于某个数的一个最大数一定存在，把q[0]当做哨兵，负无穷(小于−10^9即可)
        q[0] = (int) -2e9;
        // 枚举每个数
        for( int i = 0 ; i < n ; i++ ){
            // 二分搜索比当前数小的，但是在状态中最大的一个数
            int l = 0 , r = len;
            while( l < r ){
                // +1上取整
                int mid = l + r + 1 >> 1;
                if( q[mid] < a[i] ) l = mid ; //在右边
                else r = mid -1 ;   //在左边
            }
            // 更新最大值   r+1接在哪个数的后面，所以+1
            len = Math.max( len , r + 1 );
            // 更新q
            q[r + 1] = a[i];
        }

        System.out.println( len );
    }

}
