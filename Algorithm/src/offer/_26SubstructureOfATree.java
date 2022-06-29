package offer;

/**
 * @author ： CodeWater
 * @create ：2022-06-29-13:08
 * @Function Description ：26.树的子结构
 */
public class _26SubstructureOfATree {
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
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            // 判断边界情况，A或B为空空树
            if( A == null || B == null ) return false;
            /**如果能走到这里，那说明AB不为空，接下来就是递归判断子树的情况.
             ------------------遍历A中每个节点，A树中任一节点包含B就能返回true-----------------------
             */
            return isContain( A , B ) || isSubStructure(A.left , B) || isSubStructure(A.right , B);
        }

        //包含：以a为根的数是否包含b（必须从a开始）
        public boolean isContain( TreeNode a , TreeNode b ){
            // b子树为空了，说明从根到目前为止的都是匹配的
            if( b == null ) return true;
            // 到这里，b不为空，a为空了说明不匹配，或者说a不为空但是两个树对应的结点值不等
            if( a == null || a.val != b.val ) return false;
            // 到这里，b不空，a不空，并且两个树的结点值相等，继续向下递归
            return isContain(a.left , b.left) && isContain(a.right , b.right);
        }
    }
}
