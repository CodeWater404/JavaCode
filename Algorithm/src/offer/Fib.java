package offer;

/**
 * @author ： CodeWater
 * @create ：2022-03-12-16:26
 * @Function Description ：
 * 剑指 Offer 10- I. 斐波那契数列：求第n项
 */
public class Fib {

    public int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
//            思想好像是滚动数组，有时间了解一下
//            p、q分别等于后面；r则生成新的一项；这样当循环结束也就找到第n项的值（返回r）
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
    

}
