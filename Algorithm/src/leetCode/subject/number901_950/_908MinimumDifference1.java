package leetCode.subject.number901_950;

/**
 * @author ： CodeWater
 * @create ：2022-04-30-22:40
 * @Function Description ：
 */
public class _908MinimumDifference1 {
    class Solution {
        public int smallestRangeI(int[] nums, int k) {
            // 数据范围是（0， 10000）
            int min = 10010 , max = -1;
            for( int i = 0 ; i < nums.length; i++ ){
                min = Math.min( min , nums[i] );
                max = Math.max( max , nums[i] );

            }
            // 如果 max - min <= 2 * k说明数组能够化成所有相同的数，最小为0 ， 
            // 如果 max - min > 2 * k说明化不成相同的数，只能是 max - min - 2 * k(大于0的)
            return Math.max( 0 , max - min - 2 * k );
        }
    }
}
