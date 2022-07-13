package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-13-15:24
 * @Function Description ：33. 二叉搜索树的后序遍历序列
 */
public class _33ThePostOrderSequenceOfTheBinarySearchTree {
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder , 0 , postorder.length - 1 );
        }

        // 递归后序序列是否满足二叉搜索树的性质，（i，j）是从i到j一个左右根的范围
        public boolean recur( int[] postorder , int i , int j ){
            if( i >= j ) return true;
            // 
            int p = i ;
            // 找到左子树的左边界，也就是拿左右根的初始范围起点跟根结点比较，小于的都在左子树，直到大于等于
            while( postorder[p] < postorder[j] ) p++;
            // m记录下左子树的边界终点
            int m = p;
            // p继续遍历，找右子树的边界终点，起点就是上面遍历完左子树的终点
            while( postorder[p] > postorder[j] ) p++;
            // p最后走到j根处，并且以m划分的左右子树都符合判断的情况
            return p == j && recur( postorder , i , m - 1 ) && recur( postorder , m , j - 1 );
        }
    }
}
