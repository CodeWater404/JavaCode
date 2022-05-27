package leetCode.subject.number951_1000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ： CodeWater
 * @create ：2022-05-21-23:22
 * @Function Description ：在长度 2N 的数组中找出重复 N 次的元素
 */
public class _961 {
    class Solution {
        public int repeatedNTimes(int[] nums) {
            //哈希表
            Set<Integer> found = new HashSet<>();
            for (int num : nums) {
                if (!found.add(num)) {
                    return num;
                }
            }
            //不可能的情况，虽然一定存在答案
            return -1;
        }

    }
}
