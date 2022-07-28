package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-28-22:06
 * @Function Description ：43. 1～n 整数中 1 出现的次数
 */
public class _43TheNumberOfTimesAppearingInN {
    class Solution {
        public int countDigitOne(int n) {
            int digit = 1 , res = 0;
            int high = n / 10 , cur = n % 10 , low = 0 ;
            while( high != 0 || cur != 0 ){
                if( cur == 0 ) res += high * digit ;
                else if( cur == 1 ) res += high * digit + low + 1;
                else res += (high + 1) * digit ;
                low += cur * digit;
                cur = high % 10;
                high /= 10;
                digit *= 10;
            }
            return res;
        }
    }
}
