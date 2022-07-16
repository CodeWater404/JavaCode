package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-17-0:00
 * @Function Description ：62.圆圈中最后剩下的数字
 */
public class _62TheLastNumberLeftInTheCircle {
    class Solution {
        public int lastRemaining(int n, int m) {
            // dp问题，开数组，但本题每个状态都依赖前一个，所以直接用过变量x代替
            // 初始dp[1] = 0 ；
            int x = 0;
            for( int i = 2 ; i <= n ; i++ )
                x = ( x + m ) % i ;
            return x ;
        }
    }
}
