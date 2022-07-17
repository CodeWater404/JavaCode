package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-17-23:43
 * @Function Description ：29.顺时针打印矩阵
 */
public class _29PrintMatrixClockwise {
    //==========================覆盖原数组的============================
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if( matrix.length == 0 ) return new int[0];
            int n = matrix.length , m = matrix[0].length;
            int[] res = new int[ n * m ];
            int x = 0 , y = 0 , d = 0  ;
            int[] dy = {1 , 0 , -1 , 0} , dx = {0 , 1 , 0 , -1};
            for( int i = 0 ; i < n * m ; i++ ){
                res[i] = matrix[x][y];
                matrix[x][y] = Integer.MAX_VALUE;
                int a = x + dx[d] , b = y + dy[d];
                if( a < 0 || a >= n || b < 0 || b >= m || matrix[a][b] == Integer.MAX_VALUE ){
                    d = (d + 1) % 4;
                    a = x + dx[d];
                    b = y + dy[d];
                }
                x = a ;
                y = b;
            }
            return res;
        }
    }
    
    //==========================开一个标志数组的============================
    class Solution2 {
        public int[] spiralOrder(int[][] matrix) {
            if( matrix.length == 0 ) return new int[0];
            int x = 0 , y = 0 , d = 1;
            int[] dx = {-1 , 0 , 1 , 0};
            int[] dy = {0 , 1 , 0 , -1};

            int n = matrix.length ;int m = matrix[0].length;
            int[] ans = new int[n * m];

            boolean[][] flag = new boolean[n][m];
            for( int i = 0 ; i < n * m  ; i++ ){
                flag[x][y] = true;
                ans[i] = matrix[x][y];
                int a = x + dx[d]  , b = y + dy[d];
                if( a < 0 || a >= n || b < 0 || b >= m || flag[a][b] == true ){
                    d = (d + 1) % 4;
                    a = x + dx[d] ; b = y + dy[d];
                }
                x = a ; y = b;
            }
            return ans;
        }
    }
}
