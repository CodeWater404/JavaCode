package leetCode.subject.number51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-05-02-15:53
 * @Function Description ：94二叉树的中序遍历
 * 
 */
public class _94MiddleOrderOfTraversalOfBinaryTree {

    /**
     * Definition for a binary tree node.
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            inorder( root , ans );
            return ans;
        }

        // public static void inorder( TreeNode node , List<Integer> arr ){
        //     if( node != null ){
        //         inorder( node.left , arr );
        //         arr.add( node.val );
        //         inorder( node.right , arr );

        //     }
        // }

        // 官方题解写法
        public void inorder( TreeNode node , List<Integer> arr ){
            if( node == null ) return;
            inorder( node.left , arr );
            arr.add( node.val );
            inorder( node.right , arr );
        }
    }
}

                                                    