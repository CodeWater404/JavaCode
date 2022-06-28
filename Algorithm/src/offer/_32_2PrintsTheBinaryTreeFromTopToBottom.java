package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ： CodeWater
 * @create ：2022-06-28-10:38
 * @Function Description ：35_2从上到下打印二叉树
 */
public class _32_2PrintsTheBinaryTreeFromTopToBottom {
    /** //==========================这个包下面有一样的声明============================
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if( root == null ){
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while( queue.size() != 0 ){
                // 保存每一层的结点值
                List<Integer> level = new ArrayList<>();
                int currentLevelSize = queue.size();
                for( int i = 1 ; i <= currentLevelSize ; i++ ){
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if( node.left != null ) queue.offer(node.left);
                    if( node.right != null ) queue.offer( node.right );
                }
                //for循环结束，一层也就结束，level存放到答案res中
                res.add( level );
            }

            return res;
        }
    }
}
