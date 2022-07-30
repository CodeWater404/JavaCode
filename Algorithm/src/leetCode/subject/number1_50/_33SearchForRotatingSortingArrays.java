package leetCode.subject.number1_50;

/**
 * @author ： CodeWater
 * @create ：2022-07-30-22:35
 * @Function Description ：33.搜索旋转排序数组
 */
public class _33SearchForRotatingSortingArrays {
    class Solution {
        /**二分--------------注意本题是每个数字都不相同--------------------
         1.找出两段之间的分界点 ， 段内满足x >= nums[i]，就是在同一段内
         2.二分（因为旋转之后的每段内时有序的）
         */
        public int search(int[] nums, int target) {
            if( nums.length == 0 ) return -1;

            // 初始的lr边界
            int l = 0 , r = nums.length - 1;
            while( l < r ){
                //----- 好像先是l=mid的时候，mid这里就要+1；下面那个是r=mid就不用？？？？？=----
                int mid = l + r + 1 >> 1;
                // mid大于第一个数，更新l（和nums[0]在同一个区间内）
                if( nums[mid] >= nums[0] ) l = mid;
                    // mid小于第一个数，更新r（和nums【0】不在同一个区间）
                else  r = mid - 1;

            }
            // 找出第一个有序段的范围，判断target在那个分段里面，第一个就更新l，第二个更新lr
            if( target >= nums[0] ) l = 0;
            else {
                //上面while退出后lr等价，l = r + 1;下面while退出之后lr不一致
                l += 1;
                r = nums.length - 1;
            }

            // 在有序段中查找目标值，二分-------------------先写右边界
            // while( l < r ){
            //     int mid = l + r >> 1;
            //     if(nums[mid] >= target ) r = mid;
            //     else l = mid + 1;
            // }

// ----------------------先写左边界---------------------
            while( l < r ){
                int mid = l + r + 1 >> 1 ;
                if( nums[mid] >= target ) l = mid ;
                else r = mid + 1;
            }

            // 最终判断数组中是否有target这个值
            // 用r。用l会错。比如：[1] , 0 ;最后l是1 ， r是0. --------不管上面先写那个边界，下面都必须用r！！
            if( nums[r] == target ) return r;
            return -1;
        }
    }
}
