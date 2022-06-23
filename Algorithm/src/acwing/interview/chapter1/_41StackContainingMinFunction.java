package acwing.interview.chapter1;

import java.util.Stack;

/**
 * @author ： CodeWater
 * @create ：2022-06-23-15:20
 * @Function Description ：41.包含min函数的栈
 * 需要多开一个栈来维护最小值
 */
public class _41StackContainingMinFunction {
    class MinStack {

        Stack<Integer> stk = new Stack<>();
        // 这个栈记录的是stk到目前为止存储的最小值
        Stack<Integer> stk_min = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {
            //初始化不用做处理
        }

        public void push(int x) {
            //对于源栈来说，push就直接push；最小值栈就需要比较一下看看和之前的最小值大小情况
            stk.push(x);
            if(stk_min.size() != 0 ) x = Math.min(x , stk_min.peek() );
            // skt_min为空，那就是没有最小追，现在插入就直接push，还有就是有值，x也已经更新了
            stk_min.push(x);
        }

        public void pop() {
            // 弹出的情况，两个栈都要弹出
            stk.pop();
            stk_min.pop();
        }

        public int top() {
            return stk.peek();
        }

        public int getMin() {
            return stk_min.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

}
