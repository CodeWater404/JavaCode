package leetCode.subject.number1_50;

import java.util.Stack;

/**
 * @author ： CodeWater
 * @create ：2022-07-29-16:51
 * @Function Description ：32.最长有效括号
 */
public class _32TheLongestEffectiveParentheses {
    class Solution {
        /**两个性质： 
         1. 左右括号数相等
         2. 左括号数要大于等于右括号数
         =================（把s连续的部分划分每一段，start为每一段的起点前一个位置）===============
         */
        //  栈里面存下标
        private Stack<Integer> stk = new Stack<>();

        public int longestValidParentheses(String s) {
            int res = 0 ;
            // 栈枚举每一段连续的，其实位置是每一段的开始的前一个位置
            for( int i = 0 , start = -1 ; i < s.length() ; i++ ){
                char c = s.charAt(i);
                if( c == '(' ) stk.push(i);
                    // 当前是）
                else{
                    // 栈中有元素
                    if( stk.size() > 0 ) {
                        // 匹配一个
                        stk.pop();
                        // 看看栈中是否还有元素
                        if( stk.size() > 0 ){
                            //????
                            res = Math.max( res , i - stk.peek() );
                        }else{
                            // 栈空.说明从start开始到本位段都是匹配的。一个连续的段匹配结束
                            res = Math.max( res , i - start );
                        }
                    }else{
                        // 栈空，但是来的是右括号.把遍历的段起点改为当前下标位置
                        start = i ;
                    }
                }
            }
            return res;
        }
    }
}
