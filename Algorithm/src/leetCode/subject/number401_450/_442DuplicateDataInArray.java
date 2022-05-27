package leetCode.subject.number401_450;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-05-08-12:26
 * @Function Description ：442
 */
public class _442DuplicateDataInArray {
    class Solution {
    /*
所有数都是在（1，n）之间的，下标是（0 ，n-1），从头开始遍历。
初始时数组nums 中的整数都是正数，表示尚未被访问；

当一个整数被访问时，如果该整数对应的下标处的元素是正数，则该整数尚未被访问，因此将该整数对应的下标处的元素改成其相反数，相反数是负数，表示被访问了一次；

当一个整数被访问时，如果该整数对应的下标处的元素是负数，则该整数已经被访问，因此该整数被第二次访问，即该整数是出现两次的整数。

需要注意的是，遍历数组nums 的过程中，遍历到的元素num 可能已经被改成负数，因此在计算下标index 时需要对num 取绝对值然后减1。
    */

        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> ans = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                int index = Math.abs(num) - 1;
                if (nums[index] > 0) {
                    nums[index] = -nums[index];
                } else {
                    ans.add(index + 1);
                }
            }
            return ans;
        }
    }
}
