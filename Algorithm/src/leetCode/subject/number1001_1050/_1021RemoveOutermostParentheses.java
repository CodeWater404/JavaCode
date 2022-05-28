package leetCode.subject.number1001_1050;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ： CodeWater
 * @create ：2022-05-28-17:53
 * @Function Description ：
 */
public class _1021RemoveOutermostParentheses {
    class Solution {
        public String removeOuterParentheses(String s) {
            StringBuffer ans  = new StringBuffer();
            Deque<Character> temp = new ArrayDeque<>();

            for( int i = 0 ; i < s.length() ; i++ ){
                char c = s.charAt( i );

                if( c == ')' ){
                    temp.pop();
                }
                if( !temp.isEmpty() ){
                    ans.append( c );
                }
                if( c == '(' ){
                    temp.push( c );
                }
            }

            return ans.toString();
        }
    }
}
