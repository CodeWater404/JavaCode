package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-21-15:27
 * @Function Description ：二进制中1的个数（位运算）
 * 给定一个长度为 n 的数列，请你求出数列中每个数的二进制表示中 1 的个数。
 * <p>
 * 输入格式
 * 第一行包含整数 n。
 * <p>
 * 第二行包含 n 个整数，表示整个数列。
 * <p>
 * 输出格式
 * 共一行，包含 n 个整数，其中的第 i 个数表示数列中的第 i 个数的二进制表示中 1 的个数。
 * <p>
 * 数据范围
 * 1≤n≤100000,
 * 0≤数列中元素的值≤109
 * 输入样例：
 * 5
 * 1 2 3 4 5
 * 输出样例：
 * 1 1 2 1 2
 */
public class _801NumberOf1InBinary {
    public static int N = 100010;
    public static int[] a = new int[N];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        str = br.readLine().split(" ");
        // 用来遍历str字符串的
        int i = 0;
        while (n-- > 0) {
            int x = Integer.parseInt(str[i++]);
            int res = 0;
            while (x > 0) {
                x -= lowBit(x);
                // 每减掉一个1，答案更新
                res++;
            }
            System.out.print(res + " ");
        }

    }

    /*返回x的最后一位1及其以后面的0（二进制的形式；x=10,(1010)b , lowbit(x)返回10,10
    前面的数进过与运算之后都是0 了。
    CPP中：整数的负数是原数的补码；-x = ~x + 1.
        x& -x = x & (~x + 1 ) */
    public static int lowBit(int x) {
        return x & -x;
    }
}
