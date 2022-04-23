package leetCode.subject.number201_250;

import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-04-22-13:10
 * @Function Description ：209长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _209MinimumLengthSubarray {
    //    暴力O(n2)
    class Solution1 {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            // 判断数组是否空,空无解
            if (n == 0) return 0;
            // ans记录最小的长度
            int ans = Integer.MAX_VALUE;
// 暴力：i是前缀和的左边界（开始部分）
            for (int i = 0; i < n; i++) {
                // sum记录前缀和
                int sum = 0;
                // j实际是前缀和的右边界（结束部分）
                for (int j = i; j < n; j++) {
                    sum += nums[j];
                    if (sum >= target) {
                        ans = Math.min(ans, j - i + 1);
// 找到一个前缀和大于等于target的就跳出，开始i的下一种情况
                        break;
                    }

                }
            }
// 双重for遍历完之后，就应该存储了最小的长度的前缀和，但是不一定是答案，三元运算法判断一下
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }

    //    -------------------------------------前缀和+二分搜索------------------------------------------
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int n = nums.length;
            // 判断数组是否空,空无解
            if (n == 0) return 0;
            // ans记录最小的长度
            int ans = Integer.MAX_VALUE;
            //前缀和+二分查找 sums下标从1开始遍历，多开一个长度（new的有默认值）
            int[] sums = new int[n + 1];
            for (int i = 1; i <= n; i++)
                sums[i] = sums[i - 1] + nums[i - 1];
            for (int i = 1; i <= n; i++) {
                // s记录大于等于target的值，下面二分搜索
                int s = target + sums[i - 1];
                int bound = Arrays.binarySearch(sums, s);
                if (bound < 0) {
                    // 找不到大于等于target的值，重置bound边界，方便下一次搜索
                    bound = -bound - 1;
                }
                if (bound <= n) {
                    // 找得到大于等于target的值，求和上一次的长度最小
                    ans = Math.min(ans, bound - (i - 1));
                }
            }

            // 遍历完之后，就应该存储了最小的长度的前缀和，但是不一定是答案，三元运算法判断一下
            return ans == Integer.MAX_VALUE ? 0 : ans;
        }
    }
}
