package acwing.basic.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-04-28-13:11
 * @Function Description ：
 */
public class _849DijkstraShortestPath {
    public static int N = 510, INF = 0x3f3f3f3f;
    // m边数10w是点数n的好几倍，所以是个稠密图，用邻接矩阵存储
    public static int[][] g = new int[N][N];
    public static int[] dist = new int[N];
    public static boolean[] st = new boolean[N];
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], 0x3f);

        }

        while (m-- > 0) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]),
                    c = Integer.parseInt(str[2]);
            g[a][b] = Math.min(g[a][b], c);
        }

        if (dijkstra() == INF) System.out.println("-1");
        else System.out.println(dijkstra());
    }

    public static int dijkstra() {
        Arrays.fill(dist, 0x3f);
        dist[1] = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                // System.out.println( "t: " + t );
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    // System.out.println( "进入if t："  + t );
                    t = j;
                }
            }
            System.out.println("t :" + t);
            st[t] = true;

            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
        return dist[n];
    }
}
