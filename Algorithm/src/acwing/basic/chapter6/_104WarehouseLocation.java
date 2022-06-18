package acwing.basic.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-15:43
 * @Function Description ：104.货仓选址
 */
public class _104WarehouseLocation {

    public static int N = 100010, n;
    public static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(str[i]);

        Arrays.sort(a, 0, n);

        long res = 0;
        // 数组排完序后，遍历每个元素到中位数的距离，累加到res上即可
        for (int i = 0; i < n; i++) res += Math.abs(a[i] - a[n / 2]);

        System.out.println(res);
    }

}
