package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-07-15-21:51
 * @Function Description ：39.数组中出现次数超过一半的数字
 */
public class _39TheNumberOfMoreThanHalfOfTheArrayAppearsMoreThanHalf {
    //==========================hashmap============================
    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer , Integer> hash = new HashMap<>();
            for( int num : nums ){
                if( hash.containsKey(num) ) hash.put(num , hash.get(num) + 1 );
                else hash.put( num , 1 );
            }
            for( Map.Entry<Integer , Integer> entry : hash.entrySet() ){
                if( entry.getValue() > nums.length / 2 ) return entry.getKey();
            }
            return -1;
        }
    }
    
    //==========================摩尔投票法============================
    class Solution2 {
        public int majorityElement(int[] nums) {
            // x假定是出现次数最多的众数   votes票数
            int x = 0 , votes = 0;
            for( int num : nums ){
                // 票数为0是 假定当前num是众数
                if(votes == 0 ) x = num;
                // 判断num是不是上一轮选定的众数x  是的话票数+1 ， 不是-1
                votes += num == x ? 1 : -1 ;
            }
            // 最终众数会赋给x ， 其余的都会在正负抵消
            return x;
        }
    }
}
