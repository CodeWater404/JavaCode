package acwing.basic.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-04-25-15:19
 * @Function Description ：树的重心
 * 给定一颗树，树中包含 n 个结点（编号 1∼n）和 n−1 条无向边。
 * <p>
 * 请你找到树的重心，并输出将重心删除后，剩余各个连通块中点数的最大值。
 * <p>
 * 重心定义：重心是指树中的一个结点，如果将这个点删除后，剩余各个连通块中点数的最大值最小，那么这个节点被称为树的重心。
 * <p>
 * 输入格式
 * 第一行包含整数 n，表示树的结点数。
 * <p>
 * 接下来 n−1 行，每行包含两个整数 a 和 b，表示点 a 和点 b 之间存在一条边。
 * <p>
 * 输出格式
 * 输出一个整数 m，表示将重心删除后，剩余各个连通块中点数的最大值。
 * <p>
 * 数据范围
 * 1≤n≤105
 * 输入样例
 * 9
 * 1 2
 * 1 7
 * 1 4
 * 2 8
 * 2 5
 * 4 3
 * 3 9
 * 4 6
 * 输出样例：
 * 4
 */
public class _846TheCenterOfGravityOfTheTree {
    // 无向图，N结点数量  M边数
    public static int N = 100010, M = N * 2;
    //邻接表存储树： h头结点数组；e存储该结点连接点另外一个结点编号
    public static int[] h = new int[N];
    public static int[] e = new int[M];
    // ne存储与该节点相连的结点
    public static int[] ne = new int[M];
    // idx当前结点使用的下标  n结点数   ans答案  st标记结点是否遍历过
    public static int idx, n;
    public static int ans = N;
    public static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        // 初始化头结点数组
        for (int i = 0; i < N; i++)
            h[i] = -1;

        // 构建树
        for (int i = 0; i < n - 1; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);
            // 无向图，添加边的时候要双向
            add(a, b);
            add(b, a);
        }
        // 从1号点开始深搜
        dfs(1);
        System.out.println(ans);
    }

    // 邻接表存储树，add添加头结点链表相邻的结点，头插
    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    // 深搜，返回以u为根的子树中结点的数量
    public static int dfs(int u) {
        // 标记u号结点遍历过
        st[u] = true;
//size记录删除该点后每一个连通块中结点数的最大值； sum从0开始，记录以u为根的子树结点数量
        int size = 0, sum = 0;
        // 遍历从u结点开始走的邻接表
        for (int i = h[u]; i != -1; i = ne[i]) {
            // j记录结点值，其实就是u的一个孩子（去掉u结点后，一个树分成几个连通块）
            int j = e[i];
            // 遍历过，跳过
            if (st[j]) continue;
            // s记录j为根的子树结点数量
            int s = dfs(j);
            // 更新size，u下另外子树算出的size和当前以j子树的比较
            size = Math.max(size, s);
            // 当前子树是以u为根的子树的一部分，所以sum要加上这部分
            sum += s;
        }
        // 求得u子树结点个数后，比较和u的祖宗结点连通块的数量大小，谁大记录谁
        size = Math.max(size, n - sum - 1);
        // ans重心更新，比较求出的和上一个的最大连通块数谁小，谁小记录谁，最小的最大值
        ans = Math.min(ans, size);

        // 返回加上u自己
        return sum + 1;
    }
}
