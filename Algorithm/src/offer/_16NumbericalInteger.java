package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-12-20:59
 * @Function Description ：16.数值的整数次方
 */
public class _16NumbericalInteger {
    class Solution {
        public double myPow(double x, int n) {
            if( x == 0 ) return 0;
            /*Java 代码中 int32 变量n∈[−2147483648,2147483647] ，因此当 n = -2147483648 时执行 
            n = -n会因越界而赋值出错。解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
             */
            long b = n;
            double res = 1.0;
            if( b < 0 ){
                x = 1 / x ;
                b = -b;
            }
            while( b > 0 ){
                if( (b & 1) == 1 ) res *= x;
                x *= x;
                b >>= 1;
            }
            return res;
        }
    }
}
