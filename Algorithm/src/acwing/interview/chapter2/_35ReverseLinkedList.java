package acwing.interview.chapter2;

/**
 * @author ： CodeWater
 * @create ：2022-06-23-15:06
 * @Function Description ：35.反转链表
 */

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class _35ReverseLinkedList {

    /**
     * 第一种迭代写法
     */
    class Solution1 {
        public ListNode reverseList(ListNode head) {
            // prev从null开始，cur从head开始，这样原来的链表头就会指向null！
            ListNode prev = null , cur = head;

            while( cur != null ){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            // 退出while后，prev才是真正的头结点，而cur已经走到了原来的链表最后的尾节点处，所以返回prev
            return prev;
        }
    }

    /**
     * 第二种递归写法
     */
    class Solution2 {
        /*递归函数的处理解释：把以传入head的链表反转过来，并且返回一个尾结点*/
        public ListNode reverseList(ListNode head) {
            // head空集或者只有一个结点，直接返回
            if( head == null || head.next == null ) return head;

            ListNode tail = reverseList(head.next);
            head.next.next = head;
            head.next = null;

            return tail;
        }
    }
}
