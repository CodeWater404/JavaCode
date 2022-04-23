package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ： CodeWater
 * @create ：2022-04-17-23:15
 * @Function Description ：13.机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _13RangeOfMotionOfRobot {

    public int movingCount(int m, int n, int k) {
        //  k为0，机器人只能在当前这个格子
        if (k == 0) return 1;
        Queue<int[]> queue = new LinkedList<>();
        // 向右向下的数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] flag = new boolean[m][n];
        flag[0][0] = true;
        // 入队
        queue.offer(new int[]{0, 0});
        int ans = 1;
        while (!queue.isEmpty()) {
            // 出队
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || flag[tx][ty] || get(tx) + get(ty) > k) continue;
                queue.offer(new int[]{tx, ty});
                flag[tx][ty] = true;
                ans++;
            }

        }
        return ans;
    }

    // 获取x每一位上的数之和
    public int get(int x) {
        int res = 0;
        while (res != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }


}
