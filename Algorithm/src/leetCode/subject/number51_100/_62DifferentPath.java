package leetCode.subject.number51_100;

/**
 * @author ： CodeWater
 * @create ：2022-08-04-22:13
 * @Function Description ：62. 不同路径
 */
public class _62DifferentPath {
    class Solution {
        /**f(i , j )从起点走到[i,j]的方案。
         去除第0行和第0列的边界情况，每一步都是有上方和左边走过来的。所以当前方案，由上边和
         左边相加即可
         */
        public int uniquePaths(int m, int n) {
            int[][] f = new int[n][m];
            for( int i = 0 ; i < n ; i++ ){
                for( int j = 0 ; j < m ; j++ ){
                    // 在起点方案数为1
                    if( i == 0 && j == 0 ) f[i][j] = 1;
                    else{
                        // 不在第0列，由左边列的值加来
                        if( i != 0 ) f[i][j] += f[i - 1][j];
                        // 不在第0行，由上一行的值加过来
                        if( j != 0 ) f[i][j] += f[i][j - 1];
                    }
                }
            }

            return f[n - 1][m - 1];
        }
    }
}
