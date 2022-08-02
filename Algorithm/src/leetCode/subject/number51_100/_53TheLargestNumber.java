package leetCode.subject.number51_100;

/**
 * @author ： CodeWater
 * @create ：2022-08-02-17:45
 * @Function Description ：53. 最大子数组和
 */
public class _53TheLargestNumber {
    //==========================DP最优============================
    class Solution {
        /**f[i]所有以nums[i]结尾的区间中，最大和是多少。
         时间O(n),空间O(1)
         */
        public int maxSubArray(int[] nums) {
            int res = Integer.MIN_VALUE;
            for( int i = 0 , last = 0 ; i < nums.length ; i++ ) {
                // last存储上一轮的最大值
                last = nums[i] + Math.max( last , 0 );
                res = Math.max( last , res );
            }

            return res;
        }
    }
    
    //==========================分治============================
    class Solution2 {
        /**分治（线段树？）
         */
        class Node{
            // sum整个区间总和，整个区间最大连续字段和s，最大前缀ls，最大后缀rs
            int sum , s , ls , rs ;
            // 要写构造，才不会报错
            Node(){}
            Node( int sum , int s , int ls , int rs ){
                this.sum = sum;
                this.s = s;
                this.ls = ls;
                this.rs = rs;
            }
        }

        public int maxSubArray(int[] nums) {
            int t = Integer.MIN_VALUE;
            for( int x : nums ) t = Math.max( t , x );
            if( t < 0 ) return t;

            // 递归nums从0到length
            Node res = build( nums , 0 , nums.length - 1 );
            return res.s;

        }

        public Node build( int[] nums , int l , int r ){
            // 递归到最后的叶结点(先允许区间中为空，后面再特判)
            if( l == r ){
                int v = Math.max( nums[l] , 0 );
                return new Node( nums[l] , v , v , v );
            }

            // 区间终点mid
            int mid = l + r >> 1;
            Node ll = build( nums , l , mid ) ;
            Node rr = build( nums , mid + 1 , r );

            // 递归左右区间之后需要把答案合并
            Node res = new Node();
            res.sum = ll.sum + rr.sum;
            res.s = Math.max( Math.max( ll.s , rr.s ) , ll.rs + rr.ls );
            res.ls = Math.max( ll.ls , ll.sum + rr.ls );
            res.rs = Math.max( rr.rs , rr.sum + ll.rs );

            return res;
        }
    }


}
