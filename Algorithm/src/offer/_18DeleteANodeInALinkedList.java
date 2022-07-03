package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-03-9:57
 * @Function Description ：18.删除链表的结点
 */
public class _18DeleteANodeInALinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            // 添加一个虚拟头结点，这样就不用判断第一个头结点
            ListNode virtual = new ListNode(-1) ;
            virtual.next = head;
            // head挪到第一个位置处
            head = virtual;
            while( virtual.next != null ){
                if( virtual.next.val == val ){
                    virtual.next = virtual.next.next;
                    //   这里找到目标值之后就要返回，因为给定结点都是不相同的，只有一个
                    return head.next;
                }
                virtual = virtual.next;
            }
            return head.next;
        }
    }
}
