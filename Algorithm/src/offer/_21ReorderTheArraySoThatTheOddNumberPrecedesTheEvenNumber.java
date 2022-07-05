package offer;

import org.junit.Test;

/**
 * @author ： CodeWater
 * @create ：2022-07-05-16:23
 * @Function Description ：21.调整数组顺序使奇数位于偶数前面
 */
public class _21ReorderTheArraySoThatTheOddNumberPrecedesTheEvenNumber {

    @Test
    public void exchange() {
        int[] nums = {1,2,3,4};
        int temp;
        for (int i = 0, j = nums.length - 1; i < j; ) {
            // 不加i<j，ij会越过去，导致可能刚交换的又变回原样。这里加了i<j之后，ij就是在相等的时候会退出
            while (i < j && (nums[i] % 2 == 1)) i++;
            while (i < j && (nums[j] % 2 == 0)) j--;

            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

//        return nums;
    }
    
}
