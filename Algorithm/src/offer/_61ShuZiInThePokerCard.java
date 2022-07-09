package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ： CodeWater
 * @create ：2022-07-09-13:51
 * @Function Description ：61.扑克牌中的顺子
 */
public class _61ShuZiInThePokerCard {
    class Solution {
        public boolean isStraight(int[] nums) {
            Set<Integer> repeat = new HashSet<>();
            int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
            for( int num : nums ){
                // 0是大小王，可以当成任何数
                if( num == 0 ) continue;
                max = Math.max( max , num );
                // 有重复数字，false
                min = Math.min( min , num );
                if( repeat.contains(num) ) return false;
                repeat.add( num );
            }
            // 最大值和最小值差值小于5，是连续的
            return max - min < 5 ? true : false;
        }
    }
}
