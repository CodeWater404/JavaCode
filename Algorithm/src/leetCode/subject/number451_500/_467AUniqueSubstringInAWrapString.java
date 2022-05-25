package leetCode.subject.number451_500;

import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-05-25-14:18
 * @Function Description ：467环绕字符串中的唯一子串
 * dp
 */
public class _467AUniqueSubstringInAWrapString {

    class Solution {
        /*
        题意：求的子串必须是题目中给定的s的子串！然后就是看给定p的子串数量了。注意连续
        dp。。。
        */
        public int findSubstringInWraproundString(String p) {
            //存储对应字符所有的子串数量，下标就是数字的ascii码差值
            int[] dp = new int[26];
            // k临时记录当前字母的子串数量
            int k = 0;
            for( int i = 0 ; i < p.length() ; i++ ){
                // 字符之差为 1 或 -25
                if( i > 0 && (p.charAt( i ) - p.charAt( i - 1 ) + 26 ) % 26 == 1 ){
                    k++;
                }else{
                    k = 1;
                }
                dp[p.charAt(i) - 'a'] = Math.max( dp[p.charAt(i) - 'a'] , k );
            }

            // 所有的子串数量相加
            return Arrays.stream(dp).sum();
        }
    }
}
