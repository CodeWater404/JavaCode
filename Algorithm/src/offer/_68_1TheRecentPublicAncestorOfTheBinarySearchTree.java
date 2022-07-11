package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-11-18:02
 * @Function Description ： 68.1 二叉搜索树的最近公共祖先
 */
public class _68_1TheRecentPublicAncestorOfTheBinarySearchTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        /*解题思路：
        ① 树为 二叉搜索树 ，② 树的所有节点的值都是 唯一 的。根据以上条件，可方便地判断 p,q 与 root 的子树关系，即：
    若 root.val < p.val ，则 p 在 root 右子树 中；
    若 root.val > p.val ，则 p 在 root 左子树 中；
    若 root.val = p.val ，则 p 和 root 指向 同一节点 。
    
        */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 始终保持p结点的值小于q，方便下面while遍历时不用写判断
            if( p.val > q.val ){
                TreeNode temp = p ;
                p = q;
                q = temp;
            }
            while( root != null ){
                // pq都在root结点的左子树
                if( root.val > q.val )
                    root = root.left;
                    // pq都在root结点的右子树
                else if( root.val < p.val )
                    root = root.right;
                else break;//找到
            }
            return root;
        }
    }
}
