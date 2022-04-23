package acwing.basic.chapter2;

import java.io.*;

/**
 * @author ： CodeWater
 * @create ：2022-03-28-12:59
 * @Function Description ：kmp字符串
 * 给定一个模式串S，以及一个模板串P，所有字符串中只包含大小写英文字母以及阿拉伯数字。
 * <p>
 * 模板串P在模式串S中多次作为子串出现。
 * <p>
 * 求出模板串P在模式串S中所有出现的位置的起始下标。
 * <p>
 * 输入格式
 * 第一行输入整数N，表示字符串P的长度。
 * <p>
 * 第二行输入字符串P。
 * <p>
 * 第三行输入整数M，表示字符串S的长度。
 * <p>
 * 第四行输入字符串S。
 * <p>
 * 输出格式
 * 共一行，输出所有出现位置的起始下标（下标从0开始计数），整数之间用空格隔开。
 * <p>
 * 数据范围
 * 1≤N≤105
 * 1≤M≤106
 * 输入样例：
 * 3
 * aba
 * 5
 * ababa
 * <p>
 * 输出样例：
 * 0 2
 */
public class _831KMPCharacterString {
    /*匹配过程：p和s存储字符下标都是从1开始
   1.模板串有一个next数组（ne），记录以每个字符结尾的后缀和其最长前缀相等的长度。这也是
   在匹配过程中，模板串指针j是重新回到起点还是移到某个位置上。
   2.模板串p和模式串s匹配，i从1遍历s，j从0遍历p，因为s要每次以当前字符匹配p的下一个字符
   是否相等，相等了p的j指针才能往后移++；所以i，j相差1进行各自的遍历。
   3.匹配时：当模式串s[i]!=p[j+1]这个时候就要改变j的指向从而使得s[i]前面的部分字符和p[j]
   前面的字符相等，i、j如果直接从头开始的下一个字符重新开始比较，那就是暴力了。kmp的做法
   i指针不动，改变j指向，因为模式串s和模板串p已经匹配了一部分，而p此时有ne数组存储最长
   相等的前后缀，j指向相等前缀那个位置，然后s[i]继续与p[j+1]这个位置比较，相等j++，不等
   j继续移动到上一个前后缀相等的位置。如此，便是一个优化的过程。
   
   求解next数组：跟kmp匹配一样，只不过是模式串和模板串都是p自己。
   i从2开始，j从0开始，这样i能够跟j+1相比较，也就是得到前后缀。
   （另外，子串求解是非平凡的（除了空集和它本身以外的子集），所以next【1】不用求解，为0 。
   直接从i=2开始）
   */
    public static int N = 100010;
    public static int M = 1000010;
    public static char[] p = new char[N];
    public static char[] s = new char[M];
    public static int[] ne = new int[N];
    public static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
//        获取输入
        n = Integer.parseInt(str[0]);
        str = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) p[i] = str[0].charAt(i - 1);
        str = br.readLine().split(" ");
        m = Integer.parseInt(str[0]);
        str = br.readLine().split(" ");
        for (int i = 1; i <= m; i++) s[i] = str[0].charAt(i - 1);
        
        /*获取输入另外一种写法：
        * int n = Integer.parseInt(br.readLine());
          char[] cs = br.readLine().toCharArray();
          System.arraycopy(cs, 0, ps, 1, n);
        * */

        //求解模板串pnext
        for (int i = 2, j = 0; i <= n; i++) {
            while (j != 0 && p[i] != p[j + 1]) j = ne[j];
            if (p[i] == p[j + 1]) j++;
            ne[i] = j;
        }

        // kmp匹配
        for (int i = 1, j = 0; i <= m; i++) {
            while (j != 0 && s[i] != p[j + 1]) j = ne[j];
            if (s[i] == p[j + 1]) j++;
            if (j == n) {
                // i减掉模板串p的长度就是s和p开始相等的下标
                // System.out.print( i - n + " " );//超时了。。。。
                bw.write(i - n + " ");
                j = ne[j];
            }
        }
        // 刷新缓冲区，输出答案。不写不然会输出空白！！！
        bw.flush();
    }
}
