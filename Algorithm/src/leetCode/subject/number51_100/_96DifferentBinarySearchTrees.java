package leetCode.subject.number51_100;

/**
 * @author ： CodeWater
 * @create ：2022-08-14-23:41
 * @Function Description ：96. 不同的二叉搜索树
 */
public class _96DifferentBinarySearchTrees {
    class Solution {
        public int numTrees(int n) {
            int[] f = new int[n + 1];
            f[0] = 1;
            for( int i = 1 ; i <= n ; i++ ){
                for( int j = 1 ; j <= i ; j++ ){
                    f[i] += f[j - 1] * f[i - j];
                }
            }
            return f[n];
        }
    }
}
