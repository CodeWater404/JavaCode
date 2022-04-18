package leetCode.subject;

/**
 * @author ： CodeWater
 * @create ：2022-04-18-15:36
 * @Function Description ：61.旋转链表
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * 示例 2：
 *
 *
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 500] 内
 * -100 <= Node.val <= 100
 * 0 <= k <= 2 * 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _61RotatingLinkedList {

//     * Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if( head == null  ) return head;
            int n = 0 ;
            for( ListNode i = head ; i != null ; i = i.next ) n++;
            k %= n;
            if( k == 0 ) return head;
            ListNode p = head;
            for( int i = 0 ; i < n - k - 1 ; i++ )p = p.next;
            ListNode tail = head;
            while( tail.next != null ) tail = tail.next;
            tail.next = head;
            head = p.next;
            p.next = null;
            return head;

        }
    }
}
