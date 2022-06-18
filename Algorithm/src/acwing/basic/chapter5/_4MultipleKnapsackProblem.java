package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-13:48
 * @Function Description ：4.多重背包问题
 */
public class _4MultipleKnapsackProblem {
    // //------有限个物品------------朴素写法----------------------

    public static int N = 110;
    //n中物品  背包体积为m
    public static int n, m;
    // v体积   w价值  s对应物品有多少件    f[i][j]状态方程：i种物品背包体积j对应能选的最大价值
    public static int[] v = new int[N];
    public static int[] w = new int[N];
    public static int[] s = new int[N];
    public static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        // 初始化
        for (int i = 1; i <= n; i++) {
            str = br.readLine().split(" ");
            v[i] = Integer.parseInt(str[0]);
            w[i] = Integer.parseInt(str[1]);
            s[i] = Integer.parseInt(str[2]);
        }

        // 遍历n种物品
        for (int i = 1; i <= n; i++) {
            // 假设背包体积从0开始，一直到最大
            for (int j = 0; j <= m; j++) {
                // 从每种物品选0件到si件，条件：选取的体积不超背包体积和物品数量不超过题目给定值
                for (int k = 0; k * v[i] <= j && k <= s[i]; k++) {
                    // 状态转义方程，减掉当前多的回退到上一层再加回来
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - v[i] * k] + k * w[i]);
                }
            }
        }
        // 输出最后状态，即答案
        System.out.println(f[n][m]);
    }


// ------有限个物品------------优化写法在多重背包2中----------------------

}
