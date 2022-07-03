package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-03-9:59
 * @Function Description ：22.链表中的第k个结点
 */
public class _22TheKTHLastNodeInALinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    
    //==========================暴力============================
    class Solution {
        // 遍历一遍得到length，然后删除length-k
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode virtual = new ListNode(-1);
            virtual.next = head;
            head = virtual ;
            int length = 0;
            while( virtual.next != null ){
                virtual = virtual.next;
                length++;
            }
            // 算出正向是第几个
            int count = length - k + 1;
// virtual从头开始
            virtual = head;
            while( virtual != null && count > 0 ){
                virtual = virtual.next;
                count--;
            }
            return virtual;
        }
    }
    
    //==========================双指针，快的先走k步============================
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode quick = head , slow = head;
        for( int i = 0 ; i < k ; i++ )
            quick = quick.next;

        while( quick != null ){
            quick = quick.next;
            slow = slow.next;
        }

        return slow;
    }
}

