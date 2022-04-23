package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-16-10:43
 * @Function Description ：
 * 子矩阵的和（前缀和的二维应用）
 * 输入一个 n 行 m 列的整数矩阵，再输入 q 个询问，每个询问包含四个整数 x1,y1,x2,y2，表示一个子矩阵的左上角坐标和右下角坐标。
 * <p>
 * 对于每个询问输出子矩阵中所有数的和。
 * <p>
 * 输入格式
 * 第一行包含三个整数 n，m，q。
 * <p>
 * 接下来 n 行，每行包含 m 个整数，表示整数矩阵。
 * <p>
 * 接下来 q 行，每行包含四个整数 x1,y1,x2,y2，表示一组询问。
 * <p>
 * 输出格式
 * 共 q 行，每行输出一个询问的结果。
 * <p>
 * 数据范围
 * 1≤n,m≤1000,
 * 1≤q≤200000,
 * 1≤x1≤x2≤n,
 * 1≤y1≤y2≤m,
 * −1000≤矩阵内元素的值≤1000
 * 输入样例：
 * 3 4 3
 * 1 7 2 4
 * 3 6 2 8
 * 2 1 2 3
 * 1 1 2 2
 * 2 1 3 4
 * 1 3 3 4
 * 输出样例：
 * 17
 * 27
 * 21
 */
public class _796SumOfSubmatrix {
    public static int N = 1010;
    public static int n, m, q;
    public static int[][] a = new int[N][N];
    public static int[][] s = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        q = Integer.parseInt(str[2]);

        for (int i = 1; i <= n; i++) {
            str = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                // 一行有j个数，for下标从1开始，str从0开始
                a[i][j] = Integer.parseInt(str[j - 1]);
// s[i][j]表示左上角矩阵的所有数的和（不一定是正方形）。
/*求法：（最好画图看一下，会很气清晰）
* (i,j)坐标上方坐标(i - 1 , j )的矩阵和左边坐标(i , j -1)的矩阵相加，多加了(i，j)左上角的矩阵，所
* 以需要减掉，即：
* s[0=s[i-1][j]+s[i][j-1]+a[i][j]-s[i-1][j-1]
PS:别忘了加上本坐标a(i,j)位置的值。
* */
                s[i][j] = s[i][j - 1] + s[i - 1][j] + a[i][j] - s[i - 1][j - 1];
            }
        }

        while (q-- > 0) {
            str = br.readLine().split(" ");
            int x1 = Integer.parseInt(str[0]), y1 = Integer.parseInt(str[1]);
            int x2 = Integer.parseInt(str[2]), y2 = Integer.parseInt(str[3]);
/*指定范围内矩阵和的求法：
* 画图之后，可以很清楚的看出红色矩阵的部分
用s[i][j]这一个大的部分矩形减掉a、b部分的矩
形和；由于减掉ab之后，多减了c那一部分的矩
形和，所以还需要再加一个c部分的矩形和。
即：
    s[x2][y2] - s[x2][y1-1] - s[x1-1][y2] + s[x1-1][y1-1] 

* */
            int ans = s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1];
            System.out.println(ans);
        }

    }
}
