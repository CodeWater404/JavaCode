package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-07-06-18:49
 * @Function Description ：802.区间和
 */
public class _802IntervalAns {
    /**
     * 数据范围比较小，可以选用前缀和。
     * 本题范围较大，考虑一下离散化,本题范围是（-10^9 , 10^9）,但是最多用到30w（n+2m）个坐标。
     * 把用到的坐标排序映射到从0开始的
     * （当然也有其他的做法）
     */


    public static int N = 300010;
    // a存储数的  s前缀和数组
    public static int[] a = new int[N];
    public static int[] s = new int[N];
    // alls存所有要离散化的值
    public static List<Integer> alls = new ArrayList<>();
    // 操作数组：add 添加一个数   query查询
    public static List<PII> add = new ArrayList<>();
    public static List<PII> query = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = toInt(str[0]), m = toInt(str[1]);

        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            int x = toInt(str[0]), c = toInt(str[1]);
            // 在下标x的位置处加上c  存入add数组
            add.add(new PII(x, c));
            // 存入要离散化的下标
            alls.add(x);
        }

        for (int i = 0; i < m; i++) {
            str = br.readLine().split(" ");
            int l = toInt(str[0]), r = toInt(str[1]);
            // 存入query数组，要查询的范围
            query.add(new PII(l, r));
            // 存入要离散化的查询下标
            alls.add(l);
            alls.add(r);
        }

        // 去重：1.排序  2.去除重复元素
        Collections.sort(alls);
        int unique = unique(alls);
        alls = alls.subList(0, unique);

        // 处理在离散化之后坐标上加上值
        for (PII item : add) {
            // 离散化之后的下标
            int x = find(item.first, alls);
            a[x] += item.second;
        }

        // 预处理前缀和（这里映射到（1，size））
        for (int i = 1; i <= alls.size(); i++) s[i] = s[i - 1] + a[i];

        // 处理m个询问
        for (PII item : query) {
            int l = find(item.first, alls), r = find(item.second, alls);
            System.out.println(s[r] - s[l - 1]);
        }
    }

    // 找到离散化之后的x的下标
    public static int find(int x, List<Integer> alls) {
        int l = 0, r = alls.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (alls.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        //映射到从1开始的自然数，因为这道题会用到前缀和，所用从1开始，减少一些边界情况
        return r + 1;
    }

    // 双指针：去除重复元素，也就是返回一段不重复元素的下标
    public static int unique(List<Integer> list) {
        int j = 0;
        // i遍历所有的数   j保存的是当前存到了哪个数（j<= i）
        for (int i = 0; i < list.size(); i++) {
            // 满足：当前是第一个数  ；当前数和上一个数不等。  那就把当前位置的数换成不重复的j
            if (i == 0 || list.get(i) != list.get(i - 1)) {
                list.set(j++, list.get(i));
            }
            // 前后两个数相等，i指针往后走，j不动
        }
        // for结束之后从（0，j-1）就是所有不重复的元素了
        return j;
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }


}

// PII要操作的数据类型
class PII implements Comparable<PII> {
    // 这里为了方便就不设置私有。（如果要求规范一点，还是写个方法他返回比较好）
    public int first, second;

    // public int getFirst(){
    //     return first;
    // }

    // public int getSecond(){
    //     return second;
    // }

    public PII(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(PII o) {
        return this.first - o.first;
    }
}
