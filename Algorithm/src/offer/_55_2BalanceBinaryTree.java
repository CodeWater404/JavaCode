package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-10-12:30
 * @Function Description ：55.2 平衡二叉树
 */
public class _55_2BalanceBinaryTree {
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
        // 判断平衡二叉树：树的深度是左右子树最大深度+1----> 左右子树高度查不能超过2
        public boolean isBalanced(TreeNode root) {
            // 不等于-1时true，是平衡二叉树
            return recursion(root) != -1;
        }

        // 0:越过叶子结点   -1：不是平衡二叉树   
        public int recursion(TreeNode root){
            if( root == null ) return 0;
            int left = recursion(root.left);
            // 剪枝，如果子树left是-1，就说明不是平衡二叉树，直接返回
            if( left == -1 ) return -1;
            int right = recursion( root.right );
            if( right == - 1 ) return -1;
            // 左右字数高度差大于2，不是； 小于2，用高的加1向上返回
            return Math.abs( left - right ) >= 2 ? -1 : Math.max( left , right ) + 1;
        }
    }
}
