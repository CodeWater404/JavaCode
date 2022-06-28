package offer;

import java.util.*;

/**
 * @author ： CodeWater
 * @create ：2022-06-28-13:34
 * @Function Description ：33_3之字型打印二叉树
 */
public class _32_3PrintTheBinaryTreeFromTopToButton {
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
        // 之字型，不存右儿子，从根走左儿子然后就是同层结点
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<List<Integer>>();
            if( root == null ) return ans;

            // Queue<TreeNode> queue = new LinkedList<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer( root );
            //标记，true，存到队尾表示从左到右的顺序；false，存到队头表示从右到左的顺序
            boolean isOrderLeft = true;
            while( queue.size() != 0 ){
//==========================queue接口没有offerlast方法，deque接口才有！！============================
//                Queue<Integer> level = new LinkedList<Integer>();
                Deque<Integer> level = new LinkedList<Integer>();
                int curSize = queue.size();
                for( int i = 0 ; i < curSize ; i++ ){
                    TreeNode cur = queue.poll();
                    if( isOrderLeft )
                        //多态是看左边， 如果要调用父类中没有的方法，则要向下转型
//                        ((LinkedList<Integer>) level).offerLast(cur.val);
//                        level.offerLast(cur.val);
                        level.offerLast(cur.val);//不向下转，需要用Deque，他有offerlast
                    else
                        level.offerFirst(cur.val);

                    if( cur.left != null ) queue.offer( cur.left );
                    if( cur.right != null ) queue.offer( cur.right );

                }
                ans.add( new LinkedList<Integer> (level) );
                isOrderLeft = !isOrderLeft;
            }

            return ans;

        }
    }

//    class Solution {
//        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//            List<List<Integer>> ans = new LinkedList<List<Integer>>();
//            if (root == null) {
//                return ans;
//            }
//
//            Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
//            nodeQueue.offer(root);
//            boolean isOrderLeft = true;
//
//            while (!nodeQueue.isEmpty()) {
//                Deque<Integer> levelList = new LinkedList<Integer>();
//                int size = nodeQueue.size();
//                for (int i = 0; i < size; ++i) {
//                    TreeNode curNode = nodeQueue.poll();
//                    if (isOrderLeft) {
//                        levelList.offerLast(curNode.val);
//                    } else {
//                        levelList.offerFirst(curNode.val);
//                    }
//                    if (curNode.left != null) {
//                        nodeQueue.offer(curNode.left);
//                    }
//                    if (curNode.right != null) {
//                        nodeQueue.offer(curNode.right);
//                    }
//                }
//                ans.add(new LinkedList<Integer>(levelList));
//                isOrderLeft = !isOrderLeft;
//            }
//
//            return ans;
//        }
//    }

}
