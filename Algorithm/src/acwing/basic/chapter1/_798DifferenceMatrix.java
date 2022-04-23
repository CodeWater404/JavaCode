package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-18-12:10
 * @Function Description ：
 * 差分矩阵（差分的二维应用）
 */
public class _798DifferenceMatrix {
    public static int N = 1010;
    // a前缀和数组 ， b差分数组
    public static int[][] a = new int[N][N];
    public static int[][] b = new int[N][N];
    // n行m列，q次询问
    public static int n, m, q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = toInt(str[0]);
        m = toInt(str[1]);
        q = toInt(str[2]);
        for (int i = 1; i <= n; i++) {
            str = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                a[i][j] = toInt(str[j - 1]);
                // 构造差分数组
                insert(i, j, i, j, a[i][j]);
            }
        }
        while (q-- > 0) {
            str = br.readLine().split(" ");
            int x1 = toInt(str[0]), y1 = toInt(str[1]);
            int x2 = toInt(str[2]), y2 = toInt(str[3]);
            int c = toInt(str[4]);
            // 改变差分数组
            insert(x1, y1, x2, y2, c);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 输出：加上当前位置、前一个位置、上方减掉左上方
                b[i][j] += b[i - 1][j] - b[i - 1][j - 1] + b[i][j - 1];
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 构造差分数组
    public static void insert(int x1, int y1, int x2, int y2, int c) {
        // 左上角和右下角的右下角加c；右上角右边和左下角下边减掉c
        b[x1][y1] += c;
        b[x2 + 1][y2 + 1] += c;
        b[x2 + 1][y1] -= c;
        b[x1][y2 + 1] -= c;
    }

    // 处理单个字符转换成int；当输入比较多的时候写个函数简化一下
    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
