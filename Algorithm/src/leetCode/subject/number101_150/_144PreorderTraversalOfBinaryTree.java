package leetCode.subject.number101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-05-02-15:59
 * @Function Description ：144二叉树的前序遍历
 */
public class _144PreorderTraversalOfBinaryTree {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right){ 
            this.val = val;                              
            this.left = left;                            
            this.right = right;
        }
    }

class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            preorder( root , ans );
            return ans;
        }

        public void preorder(TreeNode node , List<Integer> arr ){
            if( node != null ){
                arr.add( node.val );
                preorder( node.left , arr );
                preorder( node.right , arr );
            }
        }
    }
}
