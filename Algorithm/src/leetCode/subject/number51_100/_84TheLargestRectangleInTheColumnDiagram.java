package leetCode.subject.number51_100;

/**
 * @author ： CodeWater
 * @create ：2022-08-12-23:10
 * @Function Description ：84. 柱状图中最大的矩形
 */
public class _84TheLargestRectangleInTheColumnDiagram {
    class Solution {
        /**单调栈，解决的问题：找到每一个数左边离他最近的数（的下标，比他小）
         枚举上边界（每个数组元素）时：要看左右边界比当前自己高度小的位置
         */
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            // left和right数组分别记录每个元素小于该下标元素的左右边界
            int[] left = new int[n] , right = new int[n];
            // 单调栈，求元素的左右边界
            Stack<Integer> stk = new Stack<>();

// 左边界
            for( int i = 0 ; i < n ; i++ ){
                // 栈中大于等于当前元素的都出栈，直到出现小于的或者栈空
                while( stk.size() > 0 && heights[stk.peek()] >= heights[i] ) stk.pop();
                if( stk.empty() ) left[i] = -1;
                else left[i] = stk.peek();
                stk.push(i);
            }

            stk.clear();
// 右边界
            for( int i = n - 1 ; i >= 0 ; i-- ){
                while( stk.size() > 0 && heights[stk.peek()] >= heights[i] ) stk.pop();
                if( stk.empty() ) right[i] = n;
                else right[i] = stk.peek();
                stk.push(i);
            }

// 遍历每个元素，求解
            int res = 0;
            for( int i = 0 ; i < n ; i++ ){
                res = Math.max( res , heights[i] * (right[i] - left[i] - 1 ) );
            }

            return res;
        }
    }
}
