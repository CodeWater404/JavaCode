package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-07-18:41
 * @Function Description ：54.二叉搜索树的第k大结点
 */
public class _54TheKNodeOfTheBinarySearchTree {
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
        public int res  , k ;
        public int kthLargest(TreeNode root, int k) {
            this.k = k;
            dfs( root );
            return res;

        }

        // 中序遍历的倒序，右根左
        public void dfs( TreeNode root ){
            if( root == null ) return ;
            dfs( root.right );
            if( k == 0 ) return ;
            if( --k == 0 ) res = root.val;

            dfs( root.left );

        }
    }
}
