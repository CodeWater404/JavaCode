package acwing.basic.chapter3;

import java.io.IOException;
import java.util.*;

/**
 * @author ： CodeWater
 * @create ：2022-04-24-17:21
 * @Function Description ：
 */
public class _845EightDigital {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = new String();
        for (int i = 0; i < 9; i++) str += sc.next();
        System.out.println(bfs(str));
    }

    public static int bfs(String state) {
        Queue<String> q = new LinkedList<>();
        // map键记录每一步的状态，值记录走到该状态需要多少步
        Map<String, Integer> d = new HashMap<>();
        // 初始状态入队
        q.offer(state);
        // 记录初始状态的步数
        d.put(state, 0);

        // dx dy表示上右下左四个方向
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        // 结束状态的字符
        String end = "12345678x";
        // 队列不空
        while (q.size() > 0) {
            // 出队同时删除队头
            String t = q.poll();
            // 看是否到达最后状态，到达就返回步数
            if (t.equals(end)) return d.get(t);
            // 记录当前状态的步数
            int distance = d.get(t);
            // 获取x在字符串中的下标
            int k = t.indexOf("x");
            // 转化到二维数组对应的坐标
            int x = k / 3, y = k % 3;
            // 一次遍历上右下左四个方向
            for (int i = 0; i < 4; i++) {
                // ab记录下一步的坐标
                int a = x + dx[i], b = y + dy[i];
                // ab还在矩阵范围内
                if (a >= 0 && a < 3 && b >= 0 && b < 3) {
                    // 把t转换为字符数组，传入swap交换x和下一步坐标的位置
                    char[] ch = t.toCharArray();
                    swap(ch, k, a * 3 + b);
                    // t更新交换后的字符串序列
                    t = new String(ch);
                    // 看d距离map中是否有过交换后的状态，没有就入队，距离加1
                    if (!d.containsKey(t)) {
                        d.put(t, distance + 1);
                        q.offer(t);
                    }
// 还原到上一步的状态，方便遍历下一个方向
                    swap(ch, k, a * 3 + b);
                    // t还原之前的字符串序列
                    t = new String(ch);
                }
            }
        }
        // 队列遍历结束还没结束，无解
        return -1;
    }

    // 交换字符串数组中两个位置
    public static void swap(char[] ch, int a, int b) {
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;

    }

}
