package acwing.basic.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-04-18-13:49
 * @Function Description ：842.排列数字
 * 给定一个整数 n，将数字 1∼n 排成一排，将会有很多种排列方法。
 * <p>
 * 现在，请你按照字典序将所有的排列方法输出。
 * <p>
 * 输入格式
 * 共一行，包含一个整数 n。
 * <p>
 * 输出格式
 * 按字典序输出所有排列方案，每个方案占一行。
 * <p>
 * 数据范围
 * 1≤n≤7
 * 输入样例：
 * 3
 * 输出样例：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 1 2
 * 3 2 1
 */
public class _842ArrangeNumbers {
    public static int N = 10;
    // path记录一种方案
    public static int[] path = new int[N];
    // st标记数是否遍历到
    public static boolean[] st = new boolean[N];
    // 整数n
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(0);

    }

    // 深搜，u当前搜到的层次
    public static void dfs(int u) {
        // 搜到最后一层，输出path中存储结果
        if (u == n) {
            for (int i = 0; i < n; i++)
                System.out.print(path[i] + " ");
            System.out.println();
        }

        // 从1开始遍历，n属于（1，n）范围
        for (int i = 1; i <= n; i++) {
            // i没有遍历过，就加入到方案中，然后递归搜索下一层
            if (!st[i]) {
                st[i] = true;
                path[u] = i;
                dfs(u + 1);
//当dfs函数搜索完下面所有的层数之后，回到当前层，要恢复成原来的状态，方便下一次的搜索
            /*path[u] = 0;思考一下可以看出，path数组这个不需要恢复，因为每一次搜索的时候
            这个位置上的数都会被覆盖掉，不影响结果。
            但是st标记数组需要恢复，因为每一次都需要他来进行判断当前这个位置可不可以进行
            填值
            */
                st[i] = false;
            }
        }
    }
}
