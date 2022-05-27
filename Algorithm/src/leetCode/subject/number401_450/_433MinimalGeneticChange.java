package leetCode.subject.number401_450;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ： CodeWater
 * @create ：2022-05-07-14:13
 * @Function Description ：433
 */
public class _433MinimalGeneticChange {
    class Solution {
        // 暴力BFS
        public int minMutation(String start, String end, String[] bank) {
            // 特判
            if (start.equals(end)) return 0;
            // 答案
            int ans = 0;
            // 标记bank数组中谁被使用过
            boolean[] used = new boolean[bank.length];
            // 先过滤掉和初始start一样的
            for (int i = 0; i < bank.length; i++)
                if (start.equals(bank[i])) used[i] = true;
            // 队列，start入队
            Queue<String> q = new LinkedList<>();
            q.offer(start);
            while (q.size() > 0) {
                // 答案加1，一次变化
                ans++;
                int size = q.size();
                // 遍历队列
                for (int i = 0; i < size; i++) {
                    // 取出队头
                    String s = q.poll();
                    // 遍历bank数组
                    for (int j = 0; j < bank.length; j++) {
                        // 如果bank中j元素没有被使用过，并且和当前队头元素只相差1个字母
                        if (!used[j] && numOfDifference(s, bank[j]) == 1) {
                            // 判断是不是最终序列，是的话直接返回答案
                            if (end.equals(bank[j])) return ans;
                            // 不是最终，先标记使用过。然后再把j元素入队，下一次继续判断
                            used[j] = true;
                            q.add(bank[j]);
                        }

                    }
                }
            }
            // 如果能过退出while说明没有找到
            return -1;
        }

        // 用来判断2个字符串相差多少个不同的元素个数
        public int numOfDifference(String str1, String str2) {
            char c1[] = str1.toCharArray(), c2[] = str2.toCharArray();
            int count = 0;
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] != c2[i]) count++;
            }
            return count;
        }
    }
}
