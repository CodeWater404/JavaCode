package offer;

import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-07-09-13:55
 * @Function Description ：40.最小的k个数
 * 
 */
public class _40TheSmallestKNumber {
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            Arrays.sort( arr );
            int[] res = new int[k];
            for( int i  = 0 ; i < k ; i++ ){
                res[i] = arr[i];
            }
            return res;
        }
    }
}
