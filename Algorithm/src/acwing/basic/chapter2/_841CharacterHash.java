package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-04-07-15:44
 * @Function Description ：字符串哈希
 * 给定一个长度为 n 的字符串，再给定 m 个询问，每个询问包含四个整数 l1,r1,l2,r2，请你判断 [l1,r1] 和 [l2,r2] 这两个区间所包含的字符串子串是否完全相同。
 *
 * 字符串中只包含大小写英文字母和数字。
 *
 * 输入格式
 * 第一行包含整数 n 和 m，表示字符串长度和询问次数。
 *
 * 第二行包含一个长度为 n 的字符串，字符串中只包含大小写英文字母和数字。
 *
 * 接下来 m 行，每行包含四个整数 l1,r1,l2,r2，表示一次询问所涉及的两个区间。
 *
 * 注意，字符串的位置从 1 开始编号。
 *
 * 输出格式
 * 对于每个询问输出一个结果，如果两个字符串子串完全相同则输出 Yes，否则输出 No。
 *
 * 每个结果占一行。
 *
 * 数据范围
 * 1≤n,m≤105
 * 输入样例：
 * 8 3
 * aabbaabb
 * 1 3 5 7
 * 1 3 6 8
 * 1 2 1 2
 * 输出样例：
 * Yes
 * No
 * Yes
 */
public class _841CharacterHash {
    /*
预处理所有前缀的哈希，“abcd”，h[1]=a的哈希值，h[2]=ab的哈希值,h[3]=abc的哈希值，依次类推。。。
步骤：
1.把字符串看成是p进制的数；有10个字母就看成十位
2.把p进制的数转换成十进制的数
3.转换后的数模上一个数，防止过大存不上。
注意：
1.不能把一个字母映射成0。（A）p=0；（AA）p=0，（AAA）p=0，可以看到不同的字符串在十进制下
都变成0
2.经验值：p=131或者13331，Q=2的64次方（Q是映射的范围），99%的概率不会出现冲突。（这里的字符串
哈希是假定不会出现冲突）
3.用unsinged long long来存，如果溢出了就相当于取模2的64次方
*/
    
    // ASCII 范围 0 - 127，最少 128 进制，经验上取 131 或 13331 冲突率低
    public static int N = 100010 , P = 131;
    // str输入的字符串
    public static char[] str = new char[N];
    // h字符串哈希表 ， p记录每一位p进制上的p多少次方的值。如p[0]=1：p的0次方是1,
    public static long[] h = new long[N];
    public static long[] p = new long[N];
    public static int n , m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str1 = br.readLine().split(" ");
        n = Integer.parseInt( str1[0] ) ; m = Integer.parseInt( str1[1] );

        char[] str2 = br.readLine().toCharArray();
        // 初始化。
        p[0] = 1;
        for( int i = 1 ; i <= n ; i++ ){
            // 输入字符串
            str[i] = str2[i - 1];
            //   处理前缀字符串的哈希值（这里不太理解。。。。。）
            h[i] = h[i - 1] * P + str[i];//公式，预处理前缀哈希的值，因为是P进制，所以中间乘的是P
            //   记录对应位的是131的多少次方，从131开始，131的平方，后面逐渐多1.看上面p数组定义
            p[i] = p[i - 1] * P;
        }

        while( m-- > 0 ){

            str1 = br.readLine().split(" ");
            int l1 = Integer.parseInt(str1[0]) , r1 = Integer.parseInt(str1[1]);
            int l2 = Integer.parseInt(str1[2]) , r2 = Integer.parseInt(str1[3]);
            // 判断对应的区间哈希值是否相同，相同就是同一个字符串
            if( get( l1 , r1 ) == get( l2 , r2 ) ) System.out.println( "Yes" );
            else System.out.println( "No" );
        }
    }

    // 获取对应区间的哈希值，这里看图可以理解一点。但我也没完全理解
    public static long get( int l , int r ){
        return h[r] - h[l -1] * p[r - l + 1];
    }
}
