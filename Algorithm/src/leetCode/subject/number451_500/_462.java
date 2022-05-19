package leetCode.subject.number451_500;

import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-05-19-14:05
 * @Function Description ：最少移动次数使数组元素相等
 * 中位数的策略最优
 */
public class _462 {
    class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort( nums );
            int res = 0 , n = nums.length ,mid = nums[ n / 2 ];
            for( int i = 0 ; i < n ; i++ ){
                res += Math.abs( nums[i] - mid );
            }

            return res;
        }
    }
}
