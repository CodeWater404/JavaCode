package leetCode.subject.number951_1000;

/**
 * @author ： CodeWater
 * @create ：2022-05-24-12:03
 * @Function Description ：
 */
public class _965SingleValueBinaryTree {
    /*
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        public boolean isUnivalTree(TreeNode root) {
            //空树
            if (root == null) return true;

            // 判断左边
            if (root.left != null) {
                if (root.val != root.left.val || !isUnivalTree(root.left)) {
                    return false;
                }
            }

            // 判断右边
            if (root.right != null) {
                if (root.val != root.right.val || !isUnivalTree(root.right)) {
                    return false;
                }
            }

            // 单值
            return true;
        }


    }
}
