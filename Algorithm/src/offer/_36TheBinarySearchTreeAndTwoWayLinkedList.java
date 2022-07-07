package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-07-18:24
 * @Function Description ：36.二叉搜索树与双向链表
 */

// Definition for a Node.
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val,Node1 _left,Node1 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};


public class _36TheBinarySearchTreeAndTwoWayLinkedList {
    
    class Solution {
        // pre上一个结点，left变成指向上一个结点的指针，right是下一个
        public Node1 pre , head;
        public Node1 treeToDoublyList(Node1 root) {
            if( root == null ) return null;
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        // 中序
        public void dfs( Node1 cur ){
            if( cur == null ) return ;
            dfs( cur.left );
            // 前一个结点不空，right指针指向当前
            if( pre != null ) pre.right = cur;
                // 前一个结点空，找到头结点或者
            else head = cur;
            // 当前结点left指向上一个
            cur.left = pre;
            // pre移到当前结点
            pre = cur;
            dfs( cur.right );
        }
    }
}
