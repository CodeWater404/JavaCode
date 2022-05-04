package leetCode.subject.number1801_1850;

/**
 * @author ： CodeWater
 * @create ：2022-05-04-15:05
 * @Function Description ：1823
 */
public class _1823FindTheWinnerOfTheGame {
    class Solution {
        public int findTheWinner(int n, int k) {
            // 看的题解，不太明白
            int winner = 1;
            for( int i = 2 ; i <= n ; i++ )
                winner = ( k + winner - 1) % i + 1;
            return winner;
        }
    }
}
