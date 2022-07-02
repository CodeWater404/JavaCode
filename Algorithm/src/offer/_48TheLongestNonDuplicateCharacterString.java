package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-07-02-15:26
 * @Function Description ：48.最长不含重复字符的子字符串
 */
public class _48TheLongestNonDuplicateCharacterString {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // dic记录统计 各字符最后一次出现的索引位置 。
            Map<Character , Integer> dic = new HashMap<>();
            // res记录答案    temp代替状态数组，暂存当前以j结尾的不重复的字符串长度
            int res = 0 , temp = 0;
            for( int j = 0 ; j < s.length() ; j++ ){
                // i记录以j结尾子字符串的左边界 , 如果没有，就返回-1
                int i = dic.getOrDefault( s.charAt(j) , -1);
                // 更新（有的重复字符出现多次，最后会更新最后的位置）
                dic.put( s.charAt(j) , j );
// 用dp[j - 1] 求  dp[j]， true是s[i]在区间dp[j-1]之外；false是s[i]在dp[j-1]之中，dp[j]左边界
// 由s[i]决定
                temp = temp < j - i ? temp + 1 : j - i ;
                res = Math.max( res , temp );
            }

            return res;
        }
    }
}
