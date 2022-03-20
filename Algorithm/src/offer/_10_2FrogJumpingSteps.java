package offer;

/**
 * @author ： CodeWater
 * @create ：2022-03-20-20:53
 * @Function Description ：
 * 青蛙跳台阶问题
 */
public class _10_2FrogJumpingSteps {
    public static int MOD = 1000000007;
    public int numWays(int n) {
        int a = 1 ,  b = 1 , sum = 0 ;
        for( int i = 0 ; i < n ; i++ ){
            sum = ( a + b ) % MOD;
            a = b ;
            b = sum;
        }
        return a ;
    }
}
