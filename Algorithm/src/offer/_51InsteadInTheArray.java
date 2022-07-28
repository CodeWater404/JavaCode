package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-28-17:20
 * @Function Description ：51.数组中的逆序对
 */
public class _51InsteadInTheArray {
    class Solution {
        int[] temp ;
        public int reversePairs(int[] nums) {
            if( nums.length == 0 ) return 0;
            temp = new int[nums.length];
            return mergeSort( nums , 0 , nums.length - 1 );
        }

        public int mergeSort( int[] nums , int l , int r ){
            if( l >= r ) return 0;
            int mid = l + r >> 1 ;
            int res = mergeSort(nums , l , mid ) + mergeSort( nums , mid + 1 , r );
            int k = 0 , i = l , j = mid + 1;
            while( i <= mid && j <= r ){
                if( nums[i] <= nums[j] ) temp[k++] = nums[i++];
                else{
                    res += mid - i + 1;
                    temp[k++] = nums[j++];
                }
            }
            while( i <= mid ) temp[k++] = nums[i++];
            while( j <= r ) temp[k++] = nums[j++];


            for( i = l , j = 0 ; i <= r ; i++ , j++ )
                nums[i] = temp[j];
            return res;
        }
    }
}
