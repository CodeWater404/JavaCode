package leetCode.subject.number701_750;

/**
 * @author ： CodeWater
 * @create ：2022-05-05-12:55
 * @Function Description ：713
 */
public class _713SubarrayWithProductLessThanK {
    class Solution {
        // 双指针
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            // 特判，数组都是正数，所以k小于2，就没有答案
            if( k < 2 ) return 0;
            // product乘积 ans答案
            int product = 1 , ans = 0;
            // i左边界 j右边界
            for( int i = 0 , j = 0 ; i < nums.length ; i++ ){
                // j一直往右走，停止的情况：到达数组末尾或者子数组i-j的乘积大于k
                while( j < nums.length && product < k ){
                    product *= nums[j];
                    j++;
                }
                // 判断是哪种情况，如果到达末尾但是子数组乘积还小于k。ans直接加上i-j之间的长度
                // 这个长度是i到i+1 ， i到i+2.。。这么来算的
                // 如果是因为乘积大于k而退出while的， ans只需要要加到j的前一个位置处即可，因为到j大于k，j的前一个肯定没有大于k，不然也不会走到j位置
                ans += product < k ? j - i : j - i - 1;
                product /= nums[i];
            }
            return ans;


        }
    }
}
