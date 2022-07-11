package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-12-1:04
 * @Function Description ：68.2 二叉树的最近公共祖先
 */
public class _68_2TheRecentPublicAncestorOfTheBinaryTree {
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
        // 本题是一个普通的二叉树，不是二叉搜索树！！！！！
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
       1. 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含p,q ，返回 null ；
2.当 left 和 right 同时不为空 ：说明 p,q 分列在 root 的 异侧 （分别在 左 / 右子树），因此 root为最近公共祖先，返回 rootroot ；
3.当 left 为空 ，right 不为空 ：p,q 都不在root 的左子树中，直接返回right 。具体可分为两种情况：
    3.1p,q 其中一个在 root 的 右子树 中，此时 right 指向 pp（假设为 p ）；
    3.2p,q 两节点都在 root的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
4.当 left 不为空 ， right 为空 ：与情况 3. 同理；
观察发现， 情况 1. 可合并至 3. 和 4. 内，详见文章末尾代码。


        */
            // 先序遍历
            // 终止条件：当越过叶节点，则直接返回 null ；当 root 等于 p, qp,q ，则直接返回 root ；

            if( root == null || root == p || root == q ) return root;
            TreeNode left = lowestCommonAncestor( root.left , p , q );
            TreeNode right = lowestCommonAncestor( root.right , p , q );
            // 左树空，pq在右子树中
            if( left == null ) return right ;
            // 右树空，pq在左子树中
            if( right == null ) return left;
            return root;
        }

    }
}
