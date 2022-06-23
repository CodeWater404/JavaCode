package acwing.interview.chapter1;

/**
 * @author ： CodeWater
 * @create ：2022-06-22-23:54
 * @Function Description ：34.链表中环的入口结点
 * 做法：两个指针(快指针走二步，慢指针走一步)从head开始走，第一次相遇在c点，相遇之后让第一个点回到起点，
 * 然后两个指针再同时开始走，第二次相遇就会在入口。
 */

/**
 * Definition for singly-linked list.
 */
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1(int x) {
        val = x;
        next = null;
    }
}
public class _34EntryNodeOfALinkInALinkedList {
    class Solution {
        public ListNode1 entryNodeOfLoop(ListNode1 head) {
            // 判断一些边界情况,空链表或者只有一个结点
            if( head == null || head.next == null ) return null;


            // i慢指针 ， j快指针（每次走2步）   一开始都在起点
            ListNode1 i = head , j = head;
            while( i != null && j != null ){
                // i往后走一步，j走一步然后判断是否为空，不为空再走第二步（因为如果没有环会走到空）
                i = i.next; j = j.next;
                if(j != null )  j = j.next;
                else return null;


                //i和j相遇
                if( i == j ){
                    //i回到起点
                    i = head;
                    // ij不等，两个指针在往后走一步
                    while( i != j ){
                        i = i.next;
                        j = j.next;
                    }
                    //退出while后，他们就会在入口相遇.此时i就是答案
                    return i;
                }
            }
            // 外层while如果break掉说明没有答案
            return null;
        }
    }
}
