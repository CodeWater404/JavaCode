package acwing.basic.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-14:11
 * @Function Description ：913.排队打水
 */
public class _913LineUpToFetchWater {
    // n实际排排队人数   t[i]第 i 个人装满水桶所需的时间是 ti
    public static int N = 100010, n;
    public static int[] t = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            t[i] = Integer.parseInt(str[i]);

        Arrays.sort(t, 0, n);

        // res答案累加之后，可能会爆int，所以用long来存
        long res = 0;
        // 遍历时间，累加到res
        for (int i = 0; i < n; i++)
            res += t[i] * (n - i - 1);

        System.out.println(res);
    }

}
