package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-07-14-14:51
 * @Function Description ：56.2 数组中数字出现的次数
 */
public class _56_2_NumberOfNumbersInTheArray {
    //==========================位运算============================
    class Solution {
        public int singleNumber(int[] nums) {
            int ones = 0 , twos = 0;
            for( int num : nums ){
                ones = ones ^ num & ~twos;
                twos = twos ^ num & ~ones;
            }
            return ones;
        }
    }
    
    //==========================hashmap============================
    class Solution2 {
        public int singleNumber(int[] nums) {
            Map<Integer , Integer> map = new HashMap<>();
            for( int i = 0 ; i < nums.length ; i++ ){
                if( map.containsKey(nums[i]) ) map.put( nums[i] , map.get(nums[i]) + 1 );
                else map.put(nums[i] , 1 );
            }
            for( Map.Entry<Integer , Integer>  entry : map.entrySet() ){
                if( entry.getValue() == 1 ) return entry.getKey();
            }
            return -1;
        }
    }
}
