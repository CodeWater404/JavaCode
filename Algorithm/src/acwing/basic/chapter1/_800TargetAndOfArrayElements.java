package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-20-19:49
 * @Function Description ：
 * 双指针：数组元素的目标和
 */
public class _800TargetAndOfArrayElements {
    public static int N = 100010;
    public static int[] a = new int[N];
    public static int[] b = new int[N];

    public static int n, m, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = toInt(str[0]);
        m = toInt(str[1]);
        x = toInt(str[2]);
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = toInt(str[i]);
        str = br.readLine().split(" ");
        for (int i = 0; i < m; i++) b[i] = toInt(str[i]);

        /*i从a数组往右扫描；j从b数组往左扫描；因为ij的和要为一个定值，数组都是升序，那么i在变大的同时，
         * j一定是变小的*/
        for (int i = 0, j = m - 1; i < n; i++) {
            while (a[i] + b[j] > x) j--;
            if (a[i] + b[j] == x) {
                System.out.println(i + " " + j);
//                跳出for，只输出一个答案；因为数据保证唯一解
                break;
            }
        }
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
