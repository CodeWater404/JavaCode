package offer;

import java.util.Stack;

/**
 * @author ： CodeWater
 * @create ：2022-03-11-17:38
 * @Function Description ：
 * 
 * 剑指 Offer 06. 从尾到头打印链表
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {

        //用栈！！！！
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            //java里面是链表是用点指向下一个
            temp = temp.next;

        }
        int size = stack.size();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = stack.pop().val;
        }

        return a;
    }
}
    

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }