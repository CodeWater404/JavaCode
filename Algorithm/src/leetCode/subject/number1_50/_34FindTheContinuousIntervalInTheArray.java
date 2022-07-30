package leetCode.subject.number1_50;

/**
 * @author ： CodeWater
 * @create ：2022-07-30-23:01
 * @Function Description ：34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class _34FindTheContinuousIntervalInTheArray {
    class Solution {
        // 对于有序的数组，相同的数字是连续在一起的
        // （我遇到的问题：找到lr之后，如何停止一遍）
        public int[] searchRange(int[] nums, int target) {
            if( nums.length == 0 ) return new int[]{-1 , -1};

            int l = 0 , r = nums.length - 1;
            //退出while之后就找到了连续区间的左端点！！！（看if怎么判断的就知道是找哪个边界）
            while( l < r ){
                int mid = l + r >> 1 ;
                if(nums[mid] >= target ) r = mid;
                else l = mid + 1;
            }

            // 判断找到的mid是否是mid
            if( nums[l] != target ) return new int[]{-1 , -1};
            // L记录下左端点
            int L = l ;
            l = 0 ;
            r = nums.length - 1;
            // 找连续区间的右端点，主要是if在发挥作用
            while( l < r ){
                int mid = l + r + 1 >> 1;
                if( nums[mid] <= target ) l = mid;
                else r = mid - 1;
            }

            return new int[]{L , r};
        }
    }
}
