package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ： CodeWater
 * @create ：2022-03-12-16:05
 * @Function Description ：
 * 剑指 Offer 09. 用两个栈实现队列
 */
class _9CQueue {
    //Deque双端队列；虽然题目说是用两个栈模拟队列；但是实现的时候用队列来处理模拟栈实现队列效果
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public _9CQueue() {
        //多态；第一个栈用来插入，第二个用来删除
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    //    插入
    public void appendTail(int value) {
        stack1.push(value);
    }

    //    删除；当第二个栈不空就弹出；为空但第一个栈不空就按次序弹到第二个。弹完栈2在出一个；两个栈都空则-1
    public int deleteHead() {
        // 如果第二个栈为空
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
//        第一个栈的元素入第二个栈后，栈2还是空，-1无元素
        if (stack2.isEmpty()) {
            return -1;
        } else {
//            栈2 不空就弹出
            //pop弹出元素并且返回值
            int deleteItem = stack2.pop();
            return deleteItem;
        }
    }
}

