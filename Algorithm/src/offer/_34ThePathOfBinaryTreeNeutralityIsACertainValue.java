package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-07-07-17:45
 * @Function Description ：34. 二叉树中和为某一值的路径
 */
public class _34ThePathOfBinaryTreeNeutralityIsACertainValue {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        // 总方案
        public LinkedList<List<Integer>> res = new LinkedList<>();
        // 记录当前搜索的一种方案
        public LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            dfs(root , target);
            return res;

        }

        // 先序遍历  
        public void dfs(TreeNode root , int target ){
            if( root == null ) return ;
            path.add( root.val );
            target -=root.val;
            if( target == 0 && root.left == null && root.right == null ){
                res.add( new LinkedList( path ) );
            }
            dfs( root.left , target );
            dfs( root.right , target );
            path.removeLast();
        }
    }
}
