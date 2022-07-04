package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-04-14:06
 * @Function Description ：52. 两个链表的第一个公共节点
 */
public class _52TheFirstCommonNodeOfTwoLinkedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p1 = headA , p2 = headB;
            while( p1 != p2 ){
                // a链表走完走b，两个交叉走，这样就不用判断边界空的情况
                p1 = p1 != null ? p1.next : headB;
                p2 = p2 != null ? p2.next : headA;
            }
            // 如果没有相交的点，最终p1和p2都会走到null
            return p1;
        }
    }
}
