package offer;

import java.util.Stack;

/**
 * @author ： CodeWater
 * @create ：2022-07-17-23:52
 * @Function Description ：31.栈的压入、弹出序列
 */
public class _31PressingAndPopUpSequencesOfTheStack {
    class Solution {
        // 开一个辅助栈，
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int i = 0;
            for( int num : pushed ){
                stack.push(num);
                // 栈不空，栈顶跟当前弹出顺序值一致就出栈
                while( !stack.isEmpty() && stack.peek() == popped[i] ){
                    stack.pop();
                    i++;
                }
            }
            // 遍历结束，栈中还有元素，那么就不是正确的出栈顺序
            return stack.isEmpty();
        }
    }
}
