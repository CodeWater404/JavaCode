package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ： CodeWater
 * @create ：2022-03-09-15:51
 * @Function Description ：剑指offer 03
 * 数组中重复的数字
 */
public class _3FindRepeatNumber {
    //方法一：开数组存
    public int findRepeatNumber(int[] nums) {
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (count[i] >= 2) {
                return i;
            }
        }
        //没有重复
        return 0;
    }

    /*用set集合的不可重复*/
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;

    }
}
