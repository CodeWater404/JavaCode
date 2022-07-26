package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-26-23:51
 * @Function Description ：44.数字序列中某一位的数字
 */
public class _44ANumberInADigitalSequence {
    class Solution {
        public int findNthDigit(int n) {
            // n所在的位数
            int digit = 1;
            // start当前遍历的起始位置  count当前遍历相同位数的数字共有多少个
            long start = 1 , count = 9 ;
            while( n > count ){
                n -= count;
                digit += 1;
                start *= 10;
                count = digit * start * 9;
            }
            // 第n为数字出现在num中某一位上
            long num = start + (n - 1) / digit;
            return Long.toString(num).charAt( (n - 1) % digit ) - '0';
        }
    }
}
