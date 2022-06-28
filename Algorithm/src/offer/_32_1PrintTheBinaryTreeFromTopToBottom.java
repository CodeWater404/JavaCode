package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ： CodeWater
 * @create ：2022-06-28-12:47
 * @Function Description ：32_1从上到下打印二叉树
 */
public class _32_1PrintTheBinaryTreeFromTopToBottom {
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
        public int[] levelOrder(TreeNode root) {
            if( root == null ) return new int[0];

            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while( queue.size() != 0 ){
                TreeNode cur = queue.poll();
                res.add( cur.val );

                if( cur.left != null ) queue.offer( cur.left );
                if( cur.right != null ) queue.offer( cur.right );

            }
            int[] ans = new int[res.size()];
            for( int i = 0 ; i < res.size() ; i++ )
                ans[i] = res.get(i);

            return ans;
        }
    }
}
