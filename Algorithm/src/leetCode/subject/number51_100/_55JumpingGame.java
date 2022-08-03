package leetCode.subject.number51_100;

/**
 * @author ： CodeWater
 * @create ：2022-08-03-16:46
 * @Function Description ：55.跳跃游戏
 */
public class _55JumpingGame {
    class Solution {
        /**跳跃的步数可以选择在数组元素的值以内，不一定每一步就跳定长！
         */
        public boolean canJump(int[] nums) {
            // j表示当前可以跳的最远距离
            for( int i = 0 , j = 0 ; i < nums.length ; i++ ){
                // 如果j不能大于等于i，说明无法到达该位置，那么也就无法到达最后
                if( j < i ) return false;
                // j能都到达的位置，取最大值
                j = Math.max( j , i + nums[i] );
            }
            // 遍历结束都没有return false，说明最后j还是大于等于i的，可以到达
            return true;
        }
    }
}
