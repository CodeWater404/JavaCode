package leetCode.subject.number901_950;

/**
 * @author ： CodeWater
 * @create ：2022-05-09-13:24
 * @Function Description ：942
 */
public class _942IncreaseOrDecreaseStringMatching {
    class Solution {
        // i是表示在答案数组中升序，d在答案数组中降序

        public int[] diStringMatch(String s) {
            int n = s.length() , l = 0 , r = n ;
            int[] perim = new int[n + 1];
            for( int i = 0 ; i < n ; i++ ){
                perim[i] = s.charAt(i) == 'I' ? l++ : r--;
            }
            perim[n] = l;
            return perim;
        }


    }
}
