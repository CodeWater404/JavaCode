package leetCode.subject.number101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-05-02-16:05
 * @Function Description ：二叉树的后序遍历
 */
public class _145BinaryTreePostorderTraversal {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            afterorder(root, ans);
            return ans;
        }

        public void afterorder(TreeNode node, List<Integer> arr) {
            if (node != null) {
                afterorder(node.left, arr);
                afterorder(node.right, arr);
                arr.add(node.val);
            }
        }
    }
}
