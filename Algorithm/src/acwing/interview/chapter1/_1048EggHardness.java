package acwing.interview.chapter1;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author ： CodeWater
 * @create ：2022-05-15-14:12
 * @Function Description ：1048鸡蛋的硬度
 */
public class _1048EggHardness {

    public static int N = 110, M = 11;
    public static int n, m;
    public static int[][] f = new int[N][M];


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext() && (n = sc.nextInt()) != 0 && (m = sc.nextInt()) != 0) {
            //1个鸡蛋测i个区间，必然要测i次；一层一层的去试
            for (int i = 1; i <= n; i++) f[i][1] = i;
            //高度是1，但是有j个鸡蛋，只需要测1次
            for (int j = 1; j <= m; j++) f[1][j] = 1;

            //枚举所有的状态
            for (int i = 2; i <= n; i++) {
                for (int j = 2; j <= m; j++) {
                    //第一种：对应图中的做左边情况
                    f[i][j] = f[i][j - 1];
                    //第二种：对应图中的右边情况,再分成i份枚举
                    for (int k = 1; k <= i; k++) {

                        f[i][j] = Math.min(f[i][j], Math.max(f[k - 1][j - 1], f[i - k][j]) + 1);
                    }
                }
            }
            System.out.println(f[n][m]);
        }

    }

}
