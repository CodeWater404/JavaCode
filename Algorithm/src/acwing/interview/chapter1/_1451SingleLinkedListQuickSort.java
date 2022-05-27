package acwing.interview.chapter1;

/**
 * @author ： CodeWater
 * @create ：2022-04-26-16:06
 * @Function Description ：单链表的快速排序
 * 给定一个单链表，请使用快速排序算法对其排序。
 * <p>
 * 要求：期望平均时间复杂度为 O(nlogn)，期望额外空间复杂度为 O(logn)。
 * <p>
 * 思考题： 如果只能改变链表结构，不能修改每个节点的val值该如何做呢？
 * <p>
 * 数据范围
 * 链表中的所有数大小均在 int 范围内，链表长度在 [0,10000]。
 * <p>
 * 输入样例：
 * [5, 3, 2]
 * 输出样例：
 * [2, 3, 5]
 */
public class _1451SingleLinkedListQuickSort {
    //获取指定链表的尾结点
    public static ListNode getTail(ListNode head) {
        while (head.next != null) head = head.next;
        return head;
    }

    public ListNode quickSortList(ListNode head) {
        // 判空
        if (head == null || head.next == null) return head;
        // 创建虚拟头结点
        ListNode left = new ListNode(-1);
        ListNode mid = new ListNode(-1);
        ListNode right = new ListNode(-1);

        // 创建三个对应的尾节点指针，初始指向各自头结点处
        ListNode ltail = left, mtail = mid, rtail = right;
        // 枢纽，以此来划分三个链表
        int val = head.val;
        // 遍历整个链表
        for (ListNode p = head; p != null; p = p.next) {
            // 小于val的放left链表,ltail指向p，同时尾节点指针移到新位置p处
            if (p.val < val) ltail = ltail.next = p;
                // 等于val的放mid链表,mtail指向p，同时尾节点指针移到新位置p处
            else if (p.val == val) mtail = mtail.next = p;
                // 大于val的放right链表,rtail指向p，同时尾节点指针移到新位置p处
            else rtail = rtail.next = p;
        }
        // 遍历完题目的链表划分完后，把三个链表最后指向空
        ltail.next = mtail.next = rtail.next = null;
        // 递归处理left和right链表，所以是left.next而不是left虚拟结点
        left.next = quickSortList(left.next);
        right.next = quickSortList(right.next);

        // 拼接三个链表，left的最后指向mid开头
        getTail(left).next = mid.next;
        // 拼接完left和mid后,得到新链表,再从新链表的最后指向right链表的开头
        getTail(left).next = right.next;
        // 获取拼接好后的真正链表头,所以是left.next  而不是left是-1这个虚拟结点
        ListNode p = left.next;
        // 清空三个链表头,回收
        left = mid = right = null;
        // 返回答案
        return p;
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
 