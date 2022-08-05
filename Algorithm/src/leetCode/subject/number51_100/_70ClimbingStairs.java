package leetCode.subject.number51_100;

/**
 * @author ： CodeWater
 * @create ：2022-08-05-23:29
 * @Function Description ：70.  爬楼梯
 */
public class _70ClimbingStairs {
    class Solution {
        public int climbStairs(int n) {
            /**一开始在0阶。每一次走到当前阶，都是由上一步跳到当前阶，而上一步有两种情况，
             一是跳一步；二是跳两步。相当于求一个斐波那契数列。
             */
            int a = 1 , b = 1 ;
            // 执行n-1次
            while( --n > 0 ){
                int c = a + b;
                a = b;
                b = c;
            }
            return b;
        }
    }
}
