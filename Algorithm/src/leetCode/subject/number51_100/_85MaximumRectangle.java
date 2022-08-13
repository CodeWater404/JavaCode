package leetCode.subject.number51_100;

import java.util.Stack;

/**
 * @author ： CodeWater
 * @create ：2022-08-13-23:45
 * @Function Description ：85.最大矩形
 */
public class _85MaximumRectangle {
    class Solution {
        /**变种：找正方形
         找矩形：枚举（需要优化）
         做法： 找一个下边界，然后基于这个下边界变成上一题的柱状图（每一个位置找出往上连续的1），然后求柱状图的最大矩形
         h(i,j):由位置i往上连续j个位置都是连续的1的个数。递推求得，该位置是0值为0；不是0，由当前位置1加上位置上面一个位置的值即可。

         */
        int largestRectangleArea(int[] h){
            int n = h.length ;
            int[] left = new int[n] , right = new int[n];
            Stack<Integer> stk = new Stack<>();

            for( int i = 0 ; i < n ; i++ ){
                while( stk.size() > 0 && h[stk.peek()] >= h[i] ) stk.pop();
                if( stk.size() > 0 ) left[i] = stk.peek();
                else left[i] = -1;
                stk.push( i );
            }

            stk.clear();
            for( int i = n - 1 ; i >= 0 ; i-- ){
                while( stk.size() > 0 && h[stk.peek()] >= h[i] ) stk.pop();
                if( stk.size() > 0 ) right[i] = stk.peek();
                else right[i] = n ;
                stk.push(i);
            }

            int ans = 0 ;
            for( int i = 0 ; i < n ; i++ ){
                ans = Math.max( ans , h[i] * (right[i] - left[i] - 1 ) );
            }

            return ans;
        }


        public int maximalRectangle(char[][] matrix) {
            int n = matrix.length , m = matrix[0].length;
            if( n == 0 || m == 0 ) return 0;

            // 初始化h[i][j]：表示以（i，j）为底的连续1的高度(转换成柱状图)
            int[][] h = new int[n][m];
            for( int i = 0 ; i < n ; i++ ){
                for( int j = 0 ; j < m ; j++ ){
                    if( matrix[i][j] == '1' ){
                        if( i > 0 ) h[i][j] = h[i - 1][j] + 1;
                        else h[i][j] = 1;
                    }
                }
            }

            int ans = 0;
            // 遍历每一行，求出最大矩形
            for( int i = 0 ; i < n ; i++ ){
                // largestRectangleArea求柱状图的最大矩形，这里对于二维数组来说，传一行就是以这一行作为柱状图的底
                ans = Math.max( ans , largestRectangleArea(h[i]) );
            }

            return ans;
        }
    }
}
