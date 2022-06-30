package offer;

/**
 * @author ： CodeWater
 * @create ：2022-06-30-16:47
 * @Function Description ：63. 股票的最大利润
 */
public class _63TheMaximumProfitFromTheStock {

    public static int[] f = new int[10010];

    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }

        return profit;
        
    }
}
