package leetCode.subject.number51_100;

/**
 * @author ： CodeWater
 * @create ：2022-08-06-18:14
 * @Function Description ：72. 编辑距离
 */
public class _72EditDistance {
    class Solution {
        /**DP:
         首先，先插入再删除一个字符肯定不是最优解。因为他需要两次。
         其次，操作顺序不影响结果，比如先删一个再替换和先替换在删除，这两个顺序不一样不影响结果。
         状态表示：f[i][j]：将a[1-i]变成b[1-j]的所有按顺序操作方案数。
         属性：最少值
         状态集合划分：对于当前f[i][j]可以划分成6个子集（一个字符串有三种操作，两个字符串就有6
         种），在子集中取min即可
         1.删除a的最后一个字符a[i]。f(i-1 , j) + 1
         2.在a的最后一位加一个字符。f(i , j - 1 ) + 1
         3.修改a的最后一个字符，f(i - 1 , j -1 ) + 1/0
         4.删除b[j], f( i , j - 1) + 1
         5.在b[j]后加，f( i - 1 , j ) + 1 
         6.修改b[j], f(i - 1  , j - 1 ) + 1/0
         综上，只有三种情况：f(i - 1, j) , f(i , j -1 ) , f( i -1 , j -1)
         */
        public int minDistance(String a, String b) {
            int n = a.length() , m = b.length();
            // 为了遍历方便，把字符串前补空格，下标从1开始遍历
            a = " " + a ;
            b = " " + b;

            int[][] f = new int[n + 1][m + 1];
            for( int i = 0 ; i <= n ; i++ ) f[i][0] = i;
            for( int j = 0 ; j <= m ; j++ ) f[0][j] = j;

            for( int i = 1 ; i <= n ; i++ ){
                for( int j = 1 ; j <= m ; j++ ){
                    // 删除，添加
                    f[i][j] = Math.min( f[i - 1][j] , f[i][j - 1] )+ 1;
                    // 修改：ij位置处不相等时要加1，相等时不用加
                    f[i][j] = Math.min( f[i][j]  , f[i - 1][j - 1] + (a.charAt(i) != b.charAt(j) ? 1 : 0 ) );

                }
            }

            return f[n][m];
        }
    }
}
