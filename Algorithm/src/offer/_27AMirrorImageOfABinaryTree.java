package offer;

/**
 * @author ： CodeWater
 * @create ：2022-06-29-13:56
 * @Function Description ：27.二叉树的镜像
 */
public class _27AMirrorImageOfABinaryTree {
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
        public TreeNode mirrorTree(TreeNode root) {
            if( root == null ) return null;
            TreeNode temp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(temp);
            return root;
        }
    }
}
