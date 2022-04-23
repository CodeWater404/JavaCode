package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ： CodeWater
 * @create ：2022-03-22-14:00
 * @Function Description ：区间合并
 * 给定 n 个区间 [li,ri]，要求合并所有有交集的区间。
 * <p>
 * 注意如果在端点处相交，也算有交集。
 * <p>
 * 输出合并完成后的区间个数。
 * <p>
 * 例如：[1,3] 和 [2,6] 可以合并为一个区间 [1,6]。
 * <p>
 * 输入格式
 * 第一行包含整数 n。
 * <p>
 * 接下来 n 行，每行包含两个整数 l 和 r。
 * <p>
 * 输出格式
 * 共一行，包含一个整数，表示合并区间完成后的区间个数。
 * <p>
 * 数据范围
 * 1≤n≤100000,
 * −109≤li≤ri≤109
 * 输入样例：
 * 5
 * 1 2
 * 2 4
 * 5 6
 * 7 8
 * 7 9
 * 输出样例：
 * 3
 */
public class _803IntervalMerging {
    public static int N = 100010;//没用到其实
    //存储每个区间的端点，类型是interval
    public static ArrayList<Interval> intervals = new ArrayList<Interval>();
    // n行l，r
    public static int n;

    public static void main(String[] args) throws IOException {
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]), r = Integer.parseInt(str[1]);
            intervals.add(new Interval(l, r));
        }

        //合并
        merge();

        System.out.println(intervals.size());
    }

    public static void merge() {
        // 临时记录合并的区间，对intervals修改(修改和合并不能在同一个list中操作)
        ArrayList<Interval> temp = new ArrayList<Interval>();
        // 对所有区间左端点排序
        Collections.sort(intervals);
        //定义个两个临时区间端点，用于比较，初始值定为负无穷
        int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE;

        for (Interval i : intervals) {
            // end记录的上一个区间右端点跟当前这个区间左端点没有交集
            if (end < i.start) {
                // //这里的这个判断是防止把最开始自己定义无穷大的区间给放进去
                if (start != Integer.MIN_VALUE)
                    temp.add(new Interval(start, end));
                //然后更新一下下一个新的区间的左右端点
                start = i.start;
                end = i.end;
            } else {
                //如果有交集的话
                //那我们就需要把当前的这个区间右端点更新为较大的那个，合并掉
                end = Math.max(end, i.end);
            }
        }
        //最后把最后一个没有放进去的区间给加入到list中，这个判断主要是防止
        //  输入的是空区间
        if (start != Integer.MAX_VALUE)
            temp.add(new Interval(start, end));
        intervals = temp;
    }
}

// 存储一个区间
class Interval implements Comparable<Interval> {
    public int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // 重写比较规则
    @Override
    public int compareTo(Interval obj) {
        return Integer.compare(start, obj.start);
    }
}
