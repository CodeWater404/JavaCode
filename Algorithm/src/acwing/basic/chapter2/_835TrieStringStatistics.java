package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-30-15:35
 * @Function Description ：Trie字符串统计
 * 维护一个字符串集合，支持两种操作：
 *
 * I x 向集合中插入一个字符串 x；
 * Q x 询问一个字符串在集合中出现了多少次。
 * 共有 N 个操作，输入的字符串总长度不超过 105，字符串仅包含小写英文字母。
 *
 * 输入格式
 * 第一行包含整数 N，表示操作数。
 *
 * 接下来 N 行，每行包含一个操作指令，指令为 I x 或 Q x 中的一种。
 *
 * 输出格式
 * 对于每个询问指令 Q x，都要输出一个整数作为结果，表示 x 在集合中出现的次数。
 *
 * 每个结果占一行。
 *
 * 数据范围
 * 1≤N≤2∗104
 * 输入样例：
 * 5
 * I abc
 * Q abc
 * Q ab
 * I ab
 * Q ab
 * 输出样例：
 * 1
 * 0
 * 1
 */
public class _835TrieStringStatistics {
//因为字符串长度是10^5，所以N是这么多而不是2*10^4.
    public static int N = 100010;
    // trie树数组：第一维表示共有多长的结点，第二维表示每一个结点有多少种类型，这里英文26种
    // （遍历时走到哪个结点就看一维；这个结点是什么类型就看二维是什么）
    public static int[][] son = new int[N][26];
    // cnt数组计数每个单词有多少个，最多有N次操作，所以最多有N个单词
    public static int[] cnt = new int[N];
    // Trie树的当前下标
    public static int idx ;
    // s题目输入的字符串
    public static char[] s = new char[N];
    public static int n ;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        n = Integer.parseInt( str[0] );
        while( n-- > 0 ){
            str = br.readLine().split( " " );
            String op = str[0];
            // 分解成字符串
            s = str[1].toCharArray();
            if( op.equals( "I" ) ) {
                insert(  );
            }else if( op.equals( "Q" ) ){
                System.out.println( query() );
            }
        }

    }

    // C++的写法，包含了调试，主要是传参和for判断，原先传参用的引用
    // public static void insert(char[] s ) {
    //     int p = 0 ;
    //     // for( char i : str)System.out.print( i + " " );
    //     // System.out.println( );
    //     // System.out.println( str.length);
    //     for( int i = 0 ; s[i] != 0 ; i++ ){
    //         // System.out.print( "i:" + i + "  , s[i]: " + s[i] );
    //         int u = s[i] - 'a' ;
    //         if( son[p][u] == 0 ) son[p][u] = ++idx;
    //         p = son[p][u];
    //     }
    //     cnt[p]++;
    // }

    // 插入，其实不用传参，在main中已经把s赋值，重新指向了
    public static void insert(){
        //p：遍历树的下标， 每次从Trie根结点开始遍历
        int p = 0 ;
        // 遍历字符串，不能像C++s[i]!=0这么写，因为s赋值的时候重新指向了，长度发生变化
        // for( int i = 0 ; s[i] != 0 ; i++ ){
        for( int i = 0 ; i < s.length ; i++ ){
            // u当前字符对应的种类，把a-z映射到0-25
            int u = s[i] - 'a';
            // 当前这个字符没有，创建出来这个结点，下标增加
            if( son[p][u] == 0 ) son[p][u] = ++idx;
            // p指向到这个结点上
            p = son[p][u];
        }
        // 这个单词遍历结束后，计数加加
        cnt[p]++;
    }

    // 查询
    public static int query( ){
        int p = 0 ;
        for( int i = 0 ; i < s.length ; i++ ){

            int u = s[i] - 'a';
            // 没有这个字符，也就没有这个单词了，直接跳出for返回0
            if( son[p][u] == 0 ) return 0;
            // 有这个字符，p指向这个字符，继续下一次遍历
            p = son[p][u];
        }
        // 遍历结束，有这个单词，返回p指向位置的计数值
        return cnt[p];
    }
    
}
