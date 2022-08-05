package leetCode.subject.number51_100;

/**
 * @author ： CodeWater
 * @create ：2022-08-05-23:45
 * @Function Description ：75.  颜色分类
 */
public class _75ColorClassification {
    class Solution {
        /**本题方法特殊，背过。仅适用这个题目。本质上是一个双指针算法。要求：
         1.只扫描一遍
         2.空间要O（1）
         做法：ij从左往右扫描，k从右往左扫描。初始：ij在0处，k在最后一个位置
         扫描的过程中，保证：从0到j-1这个范围是0；从j到i-1范围是1；从k+1到n-1是2。
         当i》=k时，就可以保证排好序了。
         a[i]=0，交换ij位置上的元素；i++,j++
         a[i]=2,交换ik位置上的元素；k--，但是i不要动，因为不确定交换的元素是不是1，可能是0
         a[i]=1,i++.
         i是++，k是--，所以扫描一遍肯定已经排好序了
         */
        public void sortColors(int[] nums) {
            for( int i = 0 , j = 0 , k = nums.length - 1 ; i <= k ; ){
                if( nums[i] == 0 ) swap(nums , i++ , j++ );
                else if( nums[i] == 2 ) swap( nums , i , k-- );
                else i++;
            }
        }

        public void swap( int[] a , int i , int j ){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
