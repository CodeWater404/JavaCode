package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-20-15:58
 * @Function Description ：59.1滑动窗口的最大值
 */
public class _59_1TheMaximumValueOfSlidingWindow {
    class Solution {

        public int[] maxSlidingWindow(int[] nums, int k) {
            int length = nums.length , hh = 0 , tt = -1 ;
            // 虽然题目说数组不空，但是测试用例有。。。。。
            if( length == 0 ) return new int[0];
            // length - k + 1求得最大值个数
            int[] q = new int[length] , res = new int[length - k + 1];

            for( int i = 0 ; i < length ; i++ ){
                if( hh <= tt && q[hh] < i - k + 1 )hh ++;
                while( hh <= tt && nums[q[tt]] <= nums[i] ) tt--;
                q[++tt] = i;
                //  i - k + 1让res数组下标从0开始，不然开的数组会越界
                if( i >= k - 1 ) res[i - k + 1] = nums[q[hh]]  ;
            }

            return res;
        }
    }
}
