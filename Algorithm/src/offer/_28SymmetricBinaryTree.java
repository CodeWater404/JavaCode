package offer;

/**
 * @author ： CodeWater
 * @create ：2022-06-29-13:26
 * @Function Description ：28.对称的二叉树
 */
public class _28SymmetricBinaryTree {
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
        public boolean isSymmetric(TreeNode root) {
            // 这里其实可以写成三目运算
            if( root == null )  return true;
            else return recur( root.left , root.right );
        }

        public boolean recur( TreeNode left , TreeNode right ){
            // 左右结点都是空，true
            if( left == null && right == null ) return true;
            // 到这里必然有一个不为空，另外一个如果为空，false； 值不等也false
            if( left == null || right == null || left.val != right.val ) return false;
            // 低估下一层,左节点的左孩子跟右结点的右孩子比较（镜像）
            return recur(left.left , right.right) && recur(left.right , right.left);
        }
    }
}
