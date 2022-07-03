package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-19-15:25
 * @Function Description ：
 * 双指针：最长连续不重复子序列
 */
public class _799LongestContinuousUnrepeatedSubsequence {
    public static int N = 100010;
    //    a数组记录输入数组元素
    public static int[] a = new int[N];
    //    记录输入元素的个数
    public static int[] s = new int[N];
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        虽然输入只有一个数，但是为了后面可以继续用，所以加上split分割
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        str = br.readLine().split(" ");
        int res = 0;
//        i往前扫描，j固定左边界
        for (int i = 0, j = 0; i < n; i++) {
            a[i] = Integer.parseInt(str[i]);
//            记录a[i]出现的次数，下标是这个数字，存储的值是次数
            s[a[i]]++;
            //判断的时候是前面那个指针s[a[i]]是否大于1（也就是是否出现重复数字）,让前面的指针停下来
//            （简单来说，就是从(j , i ) 区间头扫描，看哪个数字出现重复，然后删除）
            while (j < i && s[a[i]] > 1) {
                //减掉个数的时候是判断s[a[j]]后面那个指针指向的个数
            /*这样在遇到重复子序列的时候前面指针能停下来，等后面那个指针不断减掉
            个数追到i后面不重复的位置*/
                s[a[j]]--;
//                左边界移动，知道j到i之间没有出现重复数字
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);
    }
}
