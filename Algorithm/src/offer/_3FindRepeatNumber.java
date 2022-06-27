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
    
    /*方法三： 比较交换的。。。==================================================*/
    // 把下标和数组存储的元素一一对应
    public int findRepeatNumber3(int[] nums) {
        int i = 0 ;
        while( i < nums.length ) {
            // 下标和当前元素正好相等，下一个
            if( nums[i] == i ){
                i++;
                continue;
            }
            // 两个不同下标的数组元素相同
            if( nums[nums[i]]  == nums[i] ) return nums[i];
            // 不同就交换！！！
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
