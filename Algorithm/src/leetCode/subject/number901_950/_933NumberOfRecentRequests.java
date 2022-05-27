package leetCode.subject.number901_950;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ： CodeWater
 * @create ：2022-05-06-10:32
 * @Function Description ：933
 */
public class _933NumberOfRecentRequests {
    class RecentCounter {
        // 这道题说人话就是：t代表这个员工的工号，每次新员工t加入q公司前先把工号小于t -3000的老家伙都辞退，然后再让t入职，统计q公司现有几个员工
        Queue<Integer> q;

        public RecentCounter() {
            // 得放在构造器中创建才会识别到。。。。
            q = new LinkedList<Integer>();
        }

        public int ping(int t) {
            q.offer(t);
            while (q.peek() < t - 3000) q.poll();
            return q.size();
        }
    }


}
