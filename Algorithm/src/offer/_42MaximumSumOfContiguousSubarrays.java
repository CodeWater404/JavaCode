package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-01-13:41
 * @Function Description ：42.连续子数组的最大和
 */
public class _42MaximumSumOfContiguousSubarrays {
    class Solution {
        /**原地修改数组的，保存最大和
         */
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            for( int i = 1 ; i < nums.length ; i++ ){
                // 如果前一个是负数，那么就不要，直接就是选当前一个数就行
                nums[i] += Math.max( nums[i - 1] , 0 );
                res = Math.max( res , nums[i] );
            }
            return res;
        }
    }
}
