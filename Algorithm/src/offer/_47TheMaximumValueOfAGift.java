package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-01-14:06
 * @Function Description ：47.礼物的最大价值
 */
public class _47TheMaximumValueOfAGift {
    class Solution {
        public int maxValue(int[][] grid) {
            int rows = grid.length , cols = grid[0].length;
            int[][] f = new int[rows + 1][cols + 1];
            for( int i = 1 ; i <= rows ; i++ ){
                for( int j = 1 ; j <= cols ; j++){
                    // 都是上一步的最大值加上当前走到的值比较大小。i-1是因为i从1开始遍历
                    f[i][j] = Math.max(f[i - 1][j] + grid[i - 1][j - 1] , f[i][j - 1] + grid[i - 1][j - 1]);
                }
            }

            return f[rows][cols];
        }
    }
}
