package acwing.basic.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-13:36
 * @Function Description ：148.合并果子
 */
public class _148MergeFruit {
    /*这题和区间dp中合并石子的区别就是：本题是可以任意选择哪一堆果子的；而合并石子只能选择相邻的石子。
思路：每次合并最小的两个值。用优先队列维护。
*/

    public static int N = 10010, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        // 优先队列维护堆
        Queue<Integer> heap = new PriorityQueue<>();

        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            heap.offer(Integer.parseInt(str[i]));
        }

        int res = 0;
        // 堆中元素大于1，就要合并
        while (heap.size() > 1) {
            // 取出两个最小的点，合并后再插入到堆中
            int a = heap.poll(), b = heap.poll();
            res += a + b;
            heap.offer(a + b);
        }

        System.out.println(res);

    }

}
