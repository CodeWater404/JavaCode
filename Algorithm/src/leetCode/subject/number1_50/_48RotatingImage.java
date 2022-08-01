package leetCode.subject.number1_50;

/**
 * @author ： CodeWater
 * @create ：2022-08-01-19:22
 * @Function Description ：48.旋转图像
 */
public class _48RotatingImage {
    class Solution {
        /**顺时针转90度= 先斜对角线对称反转+后对称左右反转
         （画图很容易理解）
         */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            // 先对称反转
            for( int i = 0 ; i < n ; i++ ){
                // 只枚举下三角部分
                for(int j = 0 ; j < i ; j++ ){
                    swap( matrix , i , j , j , i );
                }
            }

            // 在对称反转
            for( int i = 0 ; i < n ; i++ ){
                for( int j = 0 , k = n - 1 ; j < k ; j++ , k-- )
                    swap(matrix , i , j , i , k );
            }
        }

        public void swap( int[][] matrix , int x1 , int y1 , int x2 , int y2 ){
            int temp = matrix[x1][y1] ;
            matrix[x1][y1] = matrix[x2][y2];
            matrix[x2][y2] = temp;

        }
    }
}
