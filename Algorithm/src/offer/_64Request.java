package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-11-17:32
 * @Function Description ：64. 求1+2+…+n
 */
public class _64Request {
    class Solution {
        int res = 0 ;
        public int sumNums(int n) {
        /*需要实现 “当 n = 1n=1 时终止递归” 的需求，可通过短路效应实现.
        因为正常情况下递归需要结束条件用到if，但是本题禁止。。。
            当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归.
            为构成语句，需加一个辅助布尔量 x ，否则会报错；其余并无别的意思
        */
            boolean x = n - 1 > 0 && sumNums( n - 1 ) > 0 ;
            res += n ;
            return res;
        }

    }
}
