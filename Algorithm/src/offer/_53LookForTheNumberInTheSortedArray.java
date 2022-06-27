package offer;

/**
 * @author ： CodeWater
 * @create ：2022-06-27-22:08
 * @Function Description ：在排序数组中查找数字 
 * 统计一个数字在排序数组中出现的次数。
 */
public class _53LookForTheNumberInTheSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
            int count = 0 ;
            for( int i = 0 ; i < nums.length ; i++ ){
                if( nums[i] == target ) count++;
            }
            return count;
        }
    }
}
