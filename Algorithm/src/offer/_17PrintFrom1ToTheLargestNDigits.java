package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-25-12:53
 * @Function Description ：17. 打印从1到最大的n位数
 */
public class _17PrintFrom1ToTheLargestNDigits {
    class Solution {
        public int[] printNumbers(int n) {
            int end = (int)Math.pow( 10 ,  n ) - 1;
            int[] res = new int[end];
            for( int i = 1 ; i <= end ; i++ ){
                res[i - 1] = i;
            }
            return res;
        }
    }
}
