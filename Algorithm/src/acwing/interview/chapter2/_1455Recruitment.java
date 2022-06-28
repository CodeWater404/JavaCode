package acwing.interview.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-28-0:14
 * @Function Description ：1455,招聘
 * /*约瑟夫环：0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后
 * 从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 题意解释：
 * 4 2 3 1
 * 有4个人，2个数分别是3,1.
 * 0 ， 1， 2， 3从0开始数3次，淘汰2 ；0,1,3，然后从数1次，淘汰3；0,1，数3次，淘汰0 ；只剩1，输出。
 */

public class _1455Recruitment {

    // 最多N个整数
    public static int N = 1010;
    public static int n, m;
    public static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int T = Integer.parseInt(str[0]);
        while (T-- > 0) {
            str = br.readLine().split(" ");
            n = Integer.parseInt(str[0]);
            m = Integer.parseInt(str[1]);
            for (int i = 0; i < m; i++) a[i] = Integer.parseInt(str[i + 2]);

            int res = 0;
            for (int i = 1, j = (n - 1) % m; i < n; ) {
                i++;
                j = (j + m - 1) % m;
                res = (res + a[j]) % i;
            }
            System.out.println(res);
        }
    }

}
