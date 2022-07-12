package offer;

import java.util.Map;
import java.util.HashMap;

/**
 * @author ： CodeWater
 * @create ：2022-03-11-18:37
 * @Function Description ：
 * 剑指 Offer 07. 重建二叉树
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */
public class _7BuildTree {
    //    键为结点元素值；值为结点下标
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
//            把数组值当做键；下标当做值；这样后面求左子树结点数可以
            indexMap.put(inorder[i], i);
        }
//        传入的参数是先序和后序的下标；其实也就相当于一段范围内二叉树的范围
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    
    //    按照的层次遍历序列输出的；参数都是下标索引，这样好理解
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
//        超出范围，空
        if (preorder_left > preorder_right) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点，preorder_left是pre的下标
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点；preorder[preorder_root]根的值；get拿到值对应的下标
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来： 注意建立结点的时候用值，不要in_root，这只是个下标
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目：用的下标相减，所以可得左子树结点数
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }


    //==========================另外一种============================
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
        // 声明成员变量，方便在递归创建时使用
        int[] preorder ;
        // 键是结点值  ，  值是结点在中序中的下标。 方便在创建过程中确定左右子树范围
        Map<Integer , Integer> dic = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            for( int i = 0 ; i < inorder.length ; i++ ){
                dic.put( inorder[i] , i );
            }
            // 初始从root开始（0），范围是是整个中序范围
            return recursion( 0 , 0 , inorder.length - 1 );
        }

        // 从前序中确定根结点root，从中序中确定左右子树的范围（left,right）。 （root，left，right都是数组中的下标）
        public TreeNode recursion( int root , int left , int right ){
            // 左子树下标超过右子树，递归结束
            if( left > right ) return null;
            // 找到划分左右子树的根结点
            TreeNode node = new TreeNode( preorder[root] );
            // 找到根结点在先序中的下标
            int i = dic.get( preorder[root] );
            // 递归查找左右子树的根结点，同时创捷左右指针
            node.left = recursion( root + 1 , left , i - 1 );
            node.right = recursion( root + i - left + 1 , i + 1 , right );
            return node;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}