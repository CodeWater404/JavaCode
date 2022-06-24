package offer;

/**
 * @author ： CodeWater
 * @create ：2022-06-24-15:22
 * @Function Description ：反转链表
 */
public class _24ReverseLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null , cur = head ;
            while( cur != null ){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;

            }
            return prev;
        }
    }
}
