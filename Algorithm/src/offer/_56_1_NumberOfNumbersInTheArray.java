package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-14-14:31
 * @Function Description ：56.1数组中数字出现的次数
 */
public class _56_1_NumberOfNumbersInTheArray {
    class Solution {
        public int[] singleNumbers(int[] nums) {
            // xy记录只出现一次的数字
            int x = 0 , y = 0 , n = 0 , m = 1;
            // 异或一遍之后，n就是两个只出现一次的异或值，其余出现两次的抵消了
            for( int num : nums ){
                n ^= num;
            }
            // 通过与运算从右向左循环判断，可 获取整数x⊕y 首位 1 ，记录于 m 中
            while( (n & m) == 0 )
                m <<= 1;
            //把xy分离出来 
            for( int num : nums ){
                // 跟m相与等于1为一组，说明是其中一个
                if( (num & m) != 0 ) x ^= num;
                    // 等于0另外一组，是另外一个。        其余出现两次的会在异或过程中抵消
                else y ^= num;
            }

            return new int[]{x , y};
        }
    }
}
