package leetCode.subject.number1_50;

import java.util.*;

/**
 * @author ： CodeWater
 * @create ：2022-08-01-18:55
 * @Function Description ：49.字母异位词分组
 */
public class _49Alphabet {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String , List<String> > hash = new HashMap<>();
            for( int i = 0 ; i < strs.length ; i++ ){
                char[] c = strs[i].toCharArray();
                // 把字符变成字符串排序之后就好处理了，原来乱序的都会一样
                Arrays.sort( c );
                String s = new String(c);
                // 一开始如果不在hash中，新建一个对应的list
                if( !hash.containsKey(s) )
                    hash.put( s , new ArrayList<String>() );
                // s有对应的键，就把他加入到对应的值的list数组中去
                hash.get(s).add(strs[i]);
            }

            List<List<String>> res = new ArrayList<>();
            for(List<String> temp : hash.values() ) res.add(temp);

            return res;
        }
    }
}
