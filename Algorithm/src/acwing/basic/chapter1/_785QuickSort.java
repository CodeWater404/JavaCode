package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-04-17:38
 * @Function Description ：快速排序
 * 给定你一个长度为 n 的整数数列。
 * <p>
 * 请你使用快速排序对这个数列按照从小到大进行排序。
 * <p>
 * 并将排好序的数列按顺序输出。
 * <p>
 * 输入格式
 * 输入共两行，第一行包含整数 n。
 * <p>
 * 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整个数列。
 * <p>
 * 输出格式
 * 输出共一行，包含 n 个整数，表示排好序的数列。
 * <p>
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 5
 * 3 1 2 4 5
 * 输出样例：
 * 1 2 3 4 5
 */
public class _785QuickSort {
    public static int N = 100010;
    public static int[] q = new int[N];
    //    public static int[N] q;
    public static int n;

    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        for( int i = 0 ; i < n ; i++ ){
//            q[i] = sc.nextInt();
//        }
//        quick_sort( q , 0 , n - 1 );
//        
//        for( int i = 0 ; i < n ; i++)
//            System.out.print(q[i] + " ");

        //        用缓冲流时间会快一点
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        String[] strs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        quick_sort(arr, 0, n - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        reader.close();
    }

    //    快速排序:其实参数数组写不写无所谓，因为已经静态了；如果是定义的局部数组还是需要写一下然后传入
    public static void quick_sort(int[] q, int l, int r) {
        //当单个区间长度为1的时候就可以不用再分了
        if (l >= r) return;
        //定义2个左右遍历指针指针i  j 分界点x(取区间中点)  （下面的额i+j可以换成l+r，其实不影响）
        int i = l - 1, j = r + 1, x = q[(i + j) / 2];
        while (i < j) {
            /*不能这么写：
            while(q[i] <= x ) i++;
            while(q[j] >= x ) j--;
            因为i一开始就是l-1，如果先判断那就是q[-1]根本不对！！！！
            */
            
            //当当前指针所指的元素小于分界点的时候，i往后走
            do i++; while (q[i] < x);
            //当当前指针所指的元素大于分界点的时候，j往前走
            do j--; while (q[j] > x);
            //如果两个指针没有相遇过，交换2个位置的元素
            //交换，也不知道java有没有提供直接交换的方法（C++有swap）
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        //递归左右区间，下面的j不能换成i，退出while后，ij的值不一定相等！！！！！！也有i>j的情况画个图可以理解这个区间问题
        quick_sort(q, l, j);
        quick_sort(q, j + 1, r);
    }
}
