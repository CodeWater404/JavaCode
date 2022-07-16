package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-07-16-23:43
 * @Function Description ：57.2 和为s的连续正数序列
 */
public class _57_2AndTheContinuousPositiveNumberSequenceOfSAndS {
    //==========================数学推导============================
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int  i = 1;
            double j = 2.0;
            List<int[]> res = new ArrayList<>();
            while( i < j ){
                // 推导出的公式
                j = (-1 + Math.sqrt( 1 + 4 * (2 * target +(long)i * i - i))) / 2 ;
                if( i < j && j == (int) j ){
                    int[] ans = new int[(int) j - i + 1];
                    for( int k = i ; k <= (int)j ; k++ )
                        ans[k - i] = k;
                    res.add(ans);
                }
                i++;
            }
            return res.toArray( new int[0][] );
        }
    }
    
    //==========================双指针============================
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int i = 1 , j =  2 , s = 3;
            List<int[]> res = new ArrayList<>();
            while( i < j ){
                if( s == target ){
                    int[] ans = new int[j - i + 1];
                    // 找到一组解（i , j）
                    for( int k = i ; k <= j ; k++ )
                        // k-i让下标回归从0开始
                        ans[k - i] = k;
                    res.add( ans );
                }
                if( s >= target ){
                    s -= i;
                    i++;
                }else{
                    j++;
                    s += j;
                }
            }

            return res.toArray( new int[0][] );
        }
    }
    
}
