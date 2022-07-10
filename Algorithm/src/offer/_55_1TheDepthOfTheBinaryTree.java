package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-07-10-12:10
 * @Function Description ：55.1 二叉树的深度
 */
public class _55_1TheDepthOfTheBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //==========================bfs============================
    class Solution {
        public int maxDepth(TreeNode root) {
            if( root == null ) return 0;
//            queue本层结点， temp下一层结点
            List<TreeNode> queue = new LinkedList<>(){{ add(root); }} , temp;
            int res = 0;
            while( queue.size() != 0 ){
                temp = new LinkedList<>();
                for( TreeNode node : queue ){
//                    扫描本层结点的孩子结点，添加到temp中
                    if( node.left != null ) temp.add(node.left);
                    if( node.right != null ) temp.add(node.right);
                }
//                队列换成下一层的结点
                queue = temp;
                res++;
            }
            return res;
        }
    }
    
    
    //==========================递归后序遍历============================
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution2 {
        public int maxDepth(TreeNode root) {
            if( root == null ) return 0;
            return Math.max( maxDepth(root.left) , maxDepth(root.right) ) + 1;
        }
    }
}
