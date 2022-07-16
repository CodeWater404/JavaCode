package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-16-23:29
 * @Function Description ：14.1 剪绳子
 */
public class _14_1CutRope {
    //==========================数学============================
    class Solution {
        // 尽可能将绳子以长度 33 等分为多段时，乘积最大.
        public int cuttingRope(int n) {
            if( n <= 3 ) return n - 1;
            // a:n/3的整数部分   b： n/3的余数
            int a = n / 3 , b =  n % 3;
            // 正好三等分
            if( b == 0 ) return (int)Math.pow( 3 , a );
            if( b == 1 ) return (int)Math.pow( 3 , a - 1 ) * 4;
            // b=2
            return (int) Math.pow( 3 , a ) * 2 ;
        }
    }
    
    
    //==========================贪心============================
}
