package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-13-15:34
 * @Function Description ：15.二进制中1的个数
 */
public class _15TheNumberOf1InBinary {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            // 注意！！！！n有可能是负数！！！！所以用不等于0判断，不能写n>0
            while( n != 0 ){
                if( (n & 1) == 1 ) res++;
                // res += n & 1;//另外一种写法
                n >>>= 1;
            }
            return res;
        }
    }
    
    //==========================n &= n - 1============================
    public class Solution2 {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int res = 0;
            while( n != 0 ){
                res++;
                //    n & (n - 1) 每次消去最右边的1
                n = n & (n - 1 );
            }
            return res;
        }
    }
}
