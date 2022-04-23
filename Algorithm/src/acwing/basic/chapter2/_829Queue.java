package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-25-15:53
 * @Function Description ：队列（存储元素下标从0开始也就是hh=0 ， tt=-1先加后赋值）
 * 实现一个队列，队列初始为空，支持四种操作：
 * <p>
 * push x – 向队尾插入一个数 x；
 * pop – 从队头弹出一个数；
 * empty – 判断队列是否为空；
 * query – 查询队头元素。
 * 现在要对队列进行 M 个操作，其中的每个操作 3 和操作 4 都要输出相应的结果。
 * <p>
 * 输入格式
 * 第一行包含整数 M，表示操作次数。
 * <p>
 * 接下来 M 行，每行包含一个操作命令，操作命令为 push x，pop，empty，query 中的一种。
 * <p>
 * 输出格式
 * 对于每个 empty 和 query 操作都要输出一个查询结果，每个结果占一行。
 * <p>
 * 其中，empty 操作的查询结果为 YES 或 NO，query 操作的查询结果为一个整数，表示队头元素的值。
 * <p>
 * 数据范围
 * 1≤M≤100000,
 * 1≤x≤109,
 * 所有操作保证合法。
 * <p>
 * 输入样例：
 * 10
 * push 6
 * empty
 * query
 * pop
 * empty
 * push 3
 * push 4
 * pop
 * query
 * push 6
 * 输出样例：
 * NO
 * 6
 * YES
 * 4
 */
public class _829Queue {
    public static int N = 100010;
    // 队列
    public static int[] q = new int[N];
    // hh头 ， tt尾。队列存储元素从0开始
    public static int hh = 0, tt = -1;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        m = Integer.parseInt(str[0]);

        while (m-- > 0) {
            str = br.readLine().split(" ");
            String op = str[0];
            int x;
            if (op.equals("push")) {
                // tt-1先加在赋值
                x = Integer.parseInt(str[1]);
                q[++tt] = x;
            } else if (op.equals("pop")) {
                // 队列弹出的时候，hh加加
                hh++;
            } else if (op.equals("empty")) {
                if (hh <= tt) System.out.println("NO");
                else System.out.println("YES");
            } else if (op.equals("query")) {
                System.out.println(q[hh]);
            }
        }

    }
}
