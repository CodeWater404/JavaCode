package offer;

import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-07-21-23:43
 * @Function Description ：60.n个骰子的点数
 */
public class _60NDicePoint {
    class Solution {
        public double[] dicesProbability(int n) {
            double[] dp = new double[6];
            Arrays.fill( dp , 1.0 / 6.0 );
            for( int i = 2 ; i <= n ; i++ ){
                double[] temp = new double[5 * i + 1];
                for( int j = 0 ; j < dp.length ; j++ ){
                    for( int k = 0 ; k < 6 ; k++ ){
                        temp[j + k] += dp[j] / 6.0;
                    }
                }
                dp = temp;
            }

            return dp;
        }
    }
}
