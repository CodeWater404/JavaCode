package leetCode.subject.number1_50;

import java.util.Stack;

/**
 * @author ： CodeWater
 * @create ：2022-07-31-23:31
 * @Function Description ：42. 接雨水
 */
public class _42RainWater {
    class Solution {
        public int trap(int[] height) {
            // 栈存高度的下标
            Stack<Integer> stk = new Stack<>();
            int res = 0;
            // 枚举所有柱子的高度
            for(int i = 0 ; i < height.length ; i++ ){
                // 记录上一个柱子的高度，第一次0
                int last = 0;
                // 栈非空并且栈顶元素小于等于上一个高度
                while( stk.size() > 0 && height[stk.peek()] <= height[i] ) {
                    // 先加上最底下的一部分凹糟的面试
                    res += ( height[stk.peek()] - last ) * ( i - stk.peek() - 1 );
                    // 更新成大凹糟的下标
                    last = height[stk.peek()];
                    // 计算完当前凹糟后，弹出
                    stk.pop();
                }
                // 宽度 * 高度
                if( stk.size() > 0 ) res += (i - stk.peek() - 1 ) * (height[i] - last);
                // 当前元素入栈
                stk.push(i);
            }

            return res;
        }
    }
}
