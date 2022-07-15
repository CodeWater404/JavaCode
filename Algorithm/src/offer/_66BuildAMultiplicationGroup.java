package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-15-23:13
 * @Function Description ：66.构建乘积数组
 * 
 */
public class _66BuildAMultiplicationGroup {
    class Solution {
        // 题解,看图对比代码比较好理解https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
        public int[] constructArr(int[] a) {
            int len = a.length;
            if( len == 0 ) return new int[0];
            int[] b = new int[len];
            b[0] = 1;

            // 正向遍历求三角,从1开始，依次递增乘积
            for( int i = 1 ; i < len ; i++ ){
                b[i] = b[i - 1] * a[i - 1];
            }
            // 正向遍历上一个下标会储存前面的乘积，倒序遍历只能开一个temp临时存储
            int temp = 1;
            // 倒序遍历，从倒数第二个开始，依次递增乘积
            for( int i = len - 2 ; i >= 0 ; i-- ){
                temp *= a[i + 1];
                b[i] *= temp;
            }

            return b;
        }
    }
}
