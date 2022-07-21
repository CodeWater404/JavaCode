package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-21-23:32
 * @Function Description ：49.丑数
 */
public class _49UglyNumber {
    class Solution {
        public int nthUglyNumber(int n) {
            int a = 0 , b = 0 , c = 0 ;
            int[] dp = new int[n];
            dp[0] = 1;
            for( int i = 1 ; i < n ; i++ ){
                // 
                int n2 = dp[a] * 2 , n3 = dp[b] * 3 , n5 = dp[c] * 5 ;
                // 当前数是由上一个数乘三个因子相乘后结果的最小值
                dp[i] = Math.min( Math.min( n2 , n3) , n5 );
                // 看看最后结果是n2，n3，还是n5，相应的下标就加加
                if( dp[i] == n2 ) a++;
                if( dp[i] == n3 ) b++;
                if( dp[i] == n5 ) c++;
            }
            return dp[n - 1];
        }
    }
}
