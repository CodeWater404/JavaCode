package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-26-14:22
 * @Function Description ：单调栈
 * 给定一个长度为 N 的整数数列，输出每个数左边第一个比它小的数，如果不存在则输出 −1。
 * <p>
 * 输入格式
 * 第一行包含整数 N，表示数列长度。
 * <p>
 * 第二行包含 N 个整数，表示整数数列。
 * <p>
 * 输出格式
 * 共一行，包含 N 个整数，其中第 i 个数表示第 i 个数的左边第一个比它小的数，如果不存在则输出 −1。
 * <p>
 * 数据范围
 * 1≤N≤105
 * 1≤数列中元素≤109
 * 输入样例：
 * 5
 * 3 4 2 7 5
 * 输出样例：
 * -1 3 -1 2 2
 */
public class _830MonotoneStack {
    public static int N = 100010;
    // 栈
    public static int[] stk = new int[N];
    // 栈顶指针
    public static int tt = 0;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);

        // i用来遍历输入的数字 ， x表示当前输入的数字
        int i = 0, x;
        str = br.readLine().split(" ");
        while (n-- > 0) {
            x = Integer.parseInt(str[i]);
            // 当栈中还有元素并且栈顶元素大于当前元素，栈顶指针减减，弹出（但其实还在数组中）
            while (tt > 0 && stk[tt] >= x) tt--;
            // 栈中元素为空
            if (tt <= 0) System.out.print("-1" + " ");
            else {
                // 否则输出栈顶元素
                System.out.print(stk[tt] + " ");
            }
            // 然后把当前元素记录到找中
            stk[++tt] = x;
            // 遍历的变量加加
            i++;
        }

    }
}
