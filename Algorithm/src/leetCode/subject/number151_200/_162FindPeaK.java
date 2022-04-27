package leetCode.subject.number151_200;

/**
 * @author ： CodeWater
 * @create ：2022-04-27-18:13
 * @Function Description ：寻找峰值
 */
public class _162FindPeaK {
    class Solution {
        public int findPeakElement(int[] nums) {
            int n = nums.length ; long INF = Long.MIN_VALUE;
            // 左右边界
            int l = 0 , r = n - 1 ;
// 二分
            while( l < r ){
                // 中间值索引
                int mid = l + r >> 1  ;
//    中间值的左右值，不超出范围就正常赋值，超出就无穷大
                long left = mid > 0 ? nums[mid - 1] : INF;
                long right = mid < n ? nums[mid + 1 ] : INF;
// 比较大小
                if( nums[mid] > left && nums[mid] > right ) return mid;
                    // 左边大，缩小右边界，去左边找；下面同理
                else if( left > nums[mid] ) r = mid - 1;
                else  l = mid + 1;
            }

            // 二分结束。返回答案（因为所有的元素都不相等所以一定有答案）
            return l;
        }
        
//    ======================暴力=============================
public int findPeakElement2(int[] nums) {
    int idx = 0, n = nums.length;
    for( int i = 1 ; i < n ; i++ ){
        if( nums[i] > nums[idx] )
            idx = i;
    }
    return idx;
}
    }
}
