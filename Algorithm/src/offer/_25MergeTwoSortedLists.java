package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-04-13:37
 * @Function Description ：25.合并两个排序的链表
 */
public class _25MergeTwoSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode virtual = new ListNode(-1) , p = virtual;
            while( l1 != null && l2 != null ){
                if( l1.val <= l2.val ) {
                    p.next = l1;
                    l1 = l1.next;
                }else{
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }

            p.next = l1 != null ? l1 : l2 ;

            return virtual.next;
        }
    }
}
