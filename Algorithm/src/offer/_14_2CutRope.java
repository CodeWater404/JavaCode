package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-24-23:45
 * @Function Description ：14.2剪绳子
 */
public class _14_2CutRope {
    class Solution {
        // 三等分最优（贪心）
        public int cuttingRope(int n) {
            if( n < 4 ) return n - 1;
            int p = (int) 1e9 + 7 ;
            long res = 1L;
            while( n > 4 ){
                res = res * 3 % p;
                n -= 3;
            }
            return (int) (res * n % p );
        }
    }
}
