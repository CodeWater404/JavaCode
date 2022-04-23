package acwing.basic.chapter1;

import java.util.Scanner;

/**
 * @author ： CodeWater
 * @create ：2022-03-04-18:08
 * @Function Description ：第k个数（快排的应用）
 * https://www.acwing.com/problem/content/788/
 * 快排每次确定一个最小的数，所以可以用快排优化一下即可。
 * 给定一个长度为 n 的整数数列，以及一个整数 k，请用快速选择算法求出数列从小到大排序后的第 k 个数。
 * <p>
 * 输入格式
 * 第一行包含两个整数 n 和 k。
 * <p>
 * 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整数数列。
 * <p>
 * 输出格式
 * 输出一个整数，表示数列的第 k 小数。
 * <p>
 * 数据范围
 * 1≤n≤100000,
 * 1≤k≤n
 * 输入样例：
 * 5 3
 * 2 4 1 5 3
 * 输出样例：
 * 3
 */
public class _786NumberK {
    public static int N = 100010;
    public static int n, k;
    public static int[] q = new int[N];

    public static void main(String[] args) {

        // 用缓冲流490ms
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = reader.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        k = Integer.parseInt(strs[1]);
      
        strs = reader.readLine().split(" ");
        for(int i = 0; i < n; i++){
            q[i] = Integer.parseInt(strs[i]);
        }*/
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextInt();
        }
        System.out.println(quickSort(q, 0, n - 1, k));
    }

    //    其实参数数组写不写无所谓，因为已经静态了；如果是定义的局部数组还是需要写一下然后传入
    public static int quickSort(int[] arr, int l, int r, int k) {
        //确定左边最小的结果返回
        if (l >= r) return q[l];
        int i = l - 1, j = r + 1, x = q[(l + r) / 2];
        while (i < j) {
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        //退出while时，排完一趟，可以确定出一个位置的数，k小于左边长度，说明在左区间内，
        // 继续递归左边区间；否则就在右边区间，注意右边区间传k时要减掉左边区间的长度
        if (k <= j - l + 1) return quickSort(q, l, j, k);
        else return quickSort(q, j + 1, r, k - (j - l + 1));

    }
}
