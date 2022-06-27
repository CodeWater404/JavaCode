package offer;

import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-06-27-22:23
 * @Function Description ：53.2 缺失的数字
 */
public class _53_2MissingNumbers {
    class Solution {
        public int missingNumber(int[] nums) {
            Arrays.sort( nums );
            for( int i = 0 ; i < nums.length ; i++ ){
                if( nums[i] != i ){
                    return i ;
                }
            }
            //如果从0 到length -1 都有;那就只剩下n阿
            return nums.length ;
        }
    }
}
