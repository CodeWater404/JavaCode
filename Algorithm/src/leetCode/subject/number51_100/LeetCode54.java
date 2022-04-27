package leetCode.subject.number51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-04-25-13:19
 * @Function Description ：螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix/
 */
public class LeetCode54 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            int x = 0 , y = 0 , d = 1;
            int[] dx = {-1 , 0 , 1 , 0};
            int[] dy = {0 , 1 , 0 , -1};
            int n = matrix.length , m = matrix[0].length;

            boolean[][] flag = new boolean[n][m];
            for( int i = 0 ; i < n ; i++ ){
                for( int j = 0 ; j < m ; j++ ){
                    ans.add( matrix[x][y] );
                    flag[x][y] = true;
                    int a = x + dx[d]  , b = y + dy[d];
                    if( a < 0 || a >= n || b < 0 || b >= m || flag[a][b] == true  ){
                        d = (d + 1) % 4;
                        a = x + dx[d] ; b = y + dy[d];
                    }
                    x = a ; y = b;
                }
            }

            return ans;
        }
    }
}
