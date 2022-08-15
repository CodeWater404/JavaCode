package leetCode.subject.number51_100;

/**
 * @author ： CodeWater
 * @create ：2022-08-15-22:25
 * @Function Description ：98. 验证二叉搜索树
 */
public class _98VerifyBinarySearchTree {
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
        /**按照定义来判断：
         左子树小于根，右子树大于根
         */
        public boolean isValidBST(TreeNode root) {
            // 空树也是一个二叉搜索树
            if( root == null ) return true;
            // 看第一个元素是不是1，是1没问题，不是1有问题
            return dfs( root )[0] == 1 ;

        }

        int[] dfs( TreeNode root ){
            /**
             res数组有三个元素：res[0]=0表示有问题，res[0]=1表示没有问题;
             res[1]表示这个子树中的最小值
             res[2]表示这个子树中的最大值
             空树判断在另外一个函数中判断了，这里就不判断了
             */
            int[] res = { 1 , root.val , root.val };
            // 存在左子树
            if( root.left != null ){
                // t暂存左子树
                int[] t = dfs( root.left );
                // 左子树有问题或者左子树的最大值大于根，说明这不是二叉搜索树，res[0]置0表示有问题
                if( t[0] == 0 || t[2] >= root.val )res[0] = 0;
                // 同时更新res中最小值和最大值
                res[1] = Math.min( res[1] , t[1] );
                res[2] = Math.max( res[2] , t[2] );

            }
            // 存在右子树（同理）
            if( root.right != null ){
                int[] t = dfs( root.right );
                if( t[0] == 0 || t[1] <= root.val ) res[0] = 0;
                res[1] = Math.min( res[1] , t[1] );
                res[2] = Math.max( res[2] , t[2] );
            }

            return res;
        }
    }
}
