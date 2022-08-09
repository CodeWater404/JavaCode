package leetCode.subject.number51_100;

import java.util.HashMap;

/**
 * @author ： CodeWater
 * @create ：2022-08-09-23:53
 * @Function Description ：76. 最小覆盖子串
 */
public class _76MinimumCoverString {
    class Solution {
        /**滑动窗口/双指针  + 哈希表
         用这个方法需要满足的性质：
         要有单调性；当第一个指针往前走的时候，第二个指针不能往前后走，导致范围变得更大。
         用哈希表统计t中每个字符出现的次数，枚举s的时候就可方便知道ij之间是否满足t。
         还有一个哈希表统计窗口内（j，i）每个字符出现的次数，次数count加上之后没有t中字符
         出现的次数，那么有效；超过的话，就不统计进去。
         通过有效个数count来统计答案
         */
        public String minWindow(String s, String t) {
            // hs统计窗口内的   ht统计t中的字符
            Map<Character , Integer> hs = new HashMap<>() , ht = new HashMap<>();
            int count = 0;
            String res = "";

            // 统计t中的不同字符个数
            for( int i = 0 ; i < t.length() ; i++ ){
                char c = t.charAt(i);
                ht.put( c , ht.containsKey(c) ? ht.get(c) + 1 : 1 );
            }

// 双指针遍历s串
            for( int i = 0 , j = 0 ; i < s.length() ; i++ ){
                char c = s.charAt(i);
                // c在hs中有没有，有的话加1，没有就是1
                hs.put( c , hs.containsKey(c) ? hs.get(c) + 1 : 1 );
                // 判断c是不是有效：在t中，同时窗口内有小于t中的个数
                if( ht.containsKey(c) && hs.get(c) <= ht.get(c) ) count++;
//t中不包含j 或者窗口内的j个数大于t中j的个数 -------------这里保证长度最小，如果j字符有多余一直往前走
                while( j <= i && ( !ht.containsKey(s.charAt(j) ) || hs.get(s.charAt(j) ) > ht.get( s.charAt(j) )  ) ){
                    // j添加到窗口中，个数减1，j指针往前走
                    hs.put( s.charAt(j) , hs.get( s.charAt(j++) ) - 1 );

                }

// 当有效个数等于t长度说明找到一种解
                if( count == t.length() && (res.length() > (i - j + 1 ) || res.length() < 1 ) ){
                    // j到i
                    res = s.substring(j , i + 1 );
                }

            }

            return res;
        }
    }
}
