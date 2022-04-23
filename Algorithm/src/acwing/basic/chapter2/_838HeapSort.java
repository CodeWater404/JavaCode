package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-04-04-11:17
 * @Function Description ：堆排序（数组模拟）
 * 输入一个长度为 n 的整数数列，从小到大输出前 m 小的数。
 * <p>
 * 输入格式
 * 第一行包含整数 n 和 m。
 * <p>
 * 第二行包含 n 个整数，表示整数数列。
 * <p>
 * 输出格式
 * 共一行，包含 m 个整数，表示整数数列中前 m 小的数。
 * <p>
 * 数据范围
 * 1≤m≤n≤105，
 * 1≤数列中元素≤109
 * 输入样例：
 * 5 3
 * 4 5 1 3 2
 * 输出样例：
 * 1 2 3
 */
public class _838HeapSort {
    /*小根堆（数组模拟）
操作：
1. 插入一个数：heap[++size] = x ; up(size);
2. 求集合中的最小值:heap[1]
3. 删除最小值:heap[1] = heap[size] ; size-- ; down( 1 );
(后面两个操作STL容器里面的堆无法直接实现)
4. 删除任意一个元素: heap[k]=heap[size]; size--;down(k);up(k);(down,up只会有运行一个，因为k
这个点要么大于往下走，要么小于往上走) 
5. 修改任意一个元素heap[k] = x ; down(k); up(k);
*/
    public static int N = 100010;
    // heap数组
    public static int[] h = new int[N];
    // length动态记录堆得的实际长度；n堆的最大长度；m输出前面m个数
    public static int length, n, m;

    public static void main(String[] args) throws IOException {
        // 输入处理
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        length = n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        str = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) h[i] = Integer.parseInt(str[i - 1]);

        // 从n/2处开始排序，证明看图
        for (int i = n / 2; i != 0; i--) down(i);

        // 输出
        while (m-- > 0) {
            System.out.print(h[1] + " ");
            // 删除堆顶：最后一个值覆盖堆顶，然后length减减，重新对堆顶排序
            h[1] = h[length];
            length--;
//           还要再对新的堆顶元素进行down
            down(1);
        }
    }

    // 小根堆：结点值过大下沉操作
    public static void down(int u) {
        // t是记录参数结点及其孩子之中最小的结点值的下标；初始情况存储当前点，后面比较的时候会变最小
        int t = u;
        // u与其左孩子比较
        if (u * 2 <= length && h[u * 2] < h[t]) t = u * 2;
        // u与其右孩子比较
        if (u * 2 + 1 <= length && h[u * 2 + 1] < h[t]) t = u * 2 + 1;
        // 说明u就不是最小值，需要与其孩子发生交换；相等的话，u是最小值上面两个if就没有执行，则不需要交换
        if (u != t) {
            // 交换过程
            int temp = h[t];
            h[t] = h[u];
            h[u] = temp;
            // 值交换之后，又需要递归对交换之后的t结点进行继续的down操作
            down(t);
        }
    }
}
