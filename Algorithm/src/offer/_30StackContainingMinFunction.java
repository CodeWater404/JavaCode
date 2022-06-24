package offer;

import java.util.Stack;

/**
 * @author ： CodeWater
 * @create ：2022-06-24-15:21
 * @Function Description ：包含min函数的栈
 */
public class _30StackContainingMinFunction {
    class MinStack {
        Stack<Integer> stk ;
        Stack<Integer> stk_min;

        /** initialize your data structure here. */
        public MinStack() {
            stk = new Stack<Integer>();
            stk_min = new Stack<Integer>();
        }

        public void push(int x) {
            stk.push(x);
            if( stk_min.size() != 0 ) x = Math.min(x , stk_min.peek() ) ;
            stk_min.push(x );
        }

        public void pop() {
            stk.pop();
            stk_min.pop();
        }

        public int top() {
            return stk.peek();
        }

        public int min() {
            return stk_min.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
