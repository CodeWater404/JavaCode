package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-10:17
 * @Function Description ：逆序对的数量（归并）
 * 给定一个长度为 n 的整数数列，请你计算数列中的逆序对的数量。
 * <p>
 * 逆序对的定义如下：对于数列的第 i 个和第 j 个元素，如果满足 i<j 且 a[i]>a[j]，则其为一个逆序对；否则不是。
 * <p>
 * 输入格式
 * 第一行包含整数 n，表示数列的长度。
 * <p>
 * 第二行包含 n 个整数，表示整个数列。
 * <p>
 * 输出格式
 * 输出一个整数，表示逆序对的个数。
 * <p>
 * 数据范围
 * 1≤n≤100000，
 * 数列中的元素的取值范围 [1,109]。
 * <p>
 * 输入样例：
 * 6
 * 2 3 4 5 6 1
 * 输出样例：
 * 5
 */
public class _788ReverseOrderNumber {
    public static int N = 100010;
    public static int[] q = new int[N];
    public static int[] temp = new int[N];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) q[i] = Integer.parseInt(str[i]);

        System.out.println(mergeSort(q, 0, n - 1));

    }

    public static long mergeSort(int[] q, int l, int r) {
//    为什么返回0：遍历到最深的一层，也就是只有一个数的时候，自然逆序对就是0！！！！
        if (l >= r) return 0;
        int mid = l + r >> 1;
        // res答案必须定义成long，不然过不了
        long res = mergeSort(q, l, mid) + mergeSort(q, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) temp[k++] = q[i++];
            else {
                
    /*注意这里是mid-i+1 , 不是res++
    这道题是归并的变形，根据逆序对的定义，我们可以发现排序的第二种情况：左半边的起始值到i这部分都
    大于右半边的mid。 所以直接用左半边的右边界mid - i（起始处）+1 就可以得到当前逆序对的数量。
    */
                res += mid - i + 1;
                temp[k++] = q[j++];
            }
        }

        while (i <= mid) temp[k++] = q[i++];
        while (j <= r) temp[k++] = q[j++];

        for (i = l, j = 0; i <= r; i++, j++) q[i] = temp[j];
        return res;
    }
}
