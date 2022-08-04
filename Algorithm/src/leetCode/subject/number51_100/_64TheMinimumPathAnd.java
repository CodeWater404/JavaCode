package leetCode.subject.number51_100;

/**
 * @author ： CodeWater
 * @create ：2022-08-04-22:35
 * @Function Description ：64. 最小路径和
 */
public class _64TheMinimumPathAnd {
    class Solution {
        public int minPathSum(int[][] grid) {
            int n = grid.length;
            if( n == 0 ) return 0;
            int  m = grid[0].length;

            int[][] f = new int[n][m];
            for( int i = 0 ; i < n ; i++ ){
                for( int j = 0 ; j < m ; j++ ){
                    if( i == 0 && j == 0 ) f[i][j] = grid[i][j];
                    else if( i == 0 ) f[i][j] = f[i][j - 1] + grid[i][j];
                    else if( j == 0 ) f[i][j] = f[i - 1][j] + grid[i][j];
                        // 不在边界处：有上和左边的两种情况走到当前位置，看那个值更小，然后加上当前值
                    else f[i][j] = Math.min( f[i][j - 1] , f[i - 1][j] ) + grid[i][j];
                }
            }

            return f[n - 1][m - 1];
        }
    }
}
