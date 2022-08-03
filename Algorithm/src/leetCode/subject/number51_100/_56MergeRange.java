package leetCode.subject.number51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-08-03-17:13
 * @Function Description ：56. 合并区间
 */
public class _56MergeRange {
    class Solution {
        /**模板题：
         1. 按照左端点排序
         2. 当前区间的左端点和上一个区间有交集，那就更新右端点
         3. 没有交集，当前区间无需合并，保存当前区间
         */
        public int[][] merge(int[][] arr) {
            Arrays.sort( arr , (o1 , o2) -> o1[0] - o2[0]);
            List<int[]> list = new ArrayList<>();
            int l = arr[0][0]  , r = arr[0][1];

            for( int i = 1 ; i < arr.length ; i++ ){
                if( arr[i][0] > r ){
                    list.add( new int[]{l , r} );
                    l = arr[i][0];
                    r = arr[i][1];
                }else{
                    r = Math.max( arr[i][1] , r );
                }
            }
            // 加上最后一个区间
            list.add( new int[]{l , r} );

            return list.toArray( new int[list.size()][2] );
        }
    }
}
