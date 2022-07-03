package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-06-24-15:38
 * @Function Description ：复杂链表的复制
 */
public class _35ReplicationOfComplexLinkedList {
    class Solution {
        // 输入数据的意思：[7,null]第一个是结点的值，第二个是random指向的第几个结点（下标从0开始）
        public Node copyRandomList(Node head) {
            if( head == null ) return head;
            Node cur = head;
            Map<Node , Node > map = new HashMap<>();
            // 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
            while( cur != null ){
                map.put(cur , new Node(cur.val));
                cur = cur.next;
            }

            cur = head;
            // 构建新链表的 next 和 random 指向
            while( cur != null ){
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            // 返回新链表的头节点
            return map.get(head);
        }
    }
}
