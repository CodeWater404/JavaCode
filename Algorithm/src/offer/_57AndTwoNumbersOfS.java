package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-05-16:38
 * @Function Description ：57. 和为s的两个数字
 */
public class _57AndTwoNumbersOfS {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for( int i = 0 , j = nums.length - 1 ; i < j ; ){
                if( nums[i] + nums[j] > target ) j--;
                else if( nums[i] + nums[j] < target ) i++;
                else if( nums[i] + nums[j] == target ){
                    return new int[]{ nums[i] , nums[j] };

                }

            }
            return new int[0];
        }
    }
}
