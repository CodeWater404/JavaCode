package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-30-21:36
 * @Function Description ：最大异或对（Trie树）
 * 在给定的 N 个整数 A1，A2……AN 中选出两个进行 xor（异或）运算，得到的结果最大是多少？
 *
 * 输入格式
 * 第一行输入一个整数 N。
 *
 * 第二行输入 N 个整数 A1～AN。
 *
 * 输出格式
 * 输出一个整数表示答案。
 *
 * 数据范围
 * 1≤N≤105,
 * 0≤Ai<231
 * 输入样例：
 * 3
 * 1 2 3
 * 输出样例：
 * 3
 */
public class _143MaximumXORPair {
    // 最多N个数
    public static int N = 100010;
    // trie树的最大结点数：最多有10w个数，每个数最多有31位的长度,一个结点只能表示一位
    public static int M = 3000000;
    // son是Trie树，第一维表示结点数；第二维是结点的类型，记录该位0还是1。数组值表示其在trie树中第几个的索引结点
    public static int[][] son = new int[M][2];
    // trie的当前指针，0是根结点
    public static int idx = 0 ;
    // 存储题目输入的数据
    public static int[] a = new int[N];
    public static int n ;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        n = Integer.parseInt( str[0] );
        str = br.readLine().split( " " );
        for( int i = 0 ; i < n ; i++ ){
            a[i] = Integer.parseInt( str[i] );
            //  每输入一个数就在trie中建立这个数的二进制位
            insert( a[i] );
        }

        int res = 0 ;
        for( int i = 0 ; i <  n; i++ ){
            res = Math.max( res , query(a[i]) );
        }

        System.out.println( res );
    }


    public static void insert( int x ){
        // p遍历用的指针
        int p = 0 ;
        // 从一个数二进制位的最高位开始遍历
        for( int i = 30 ; i >= 0 ; i-- ){
            // x >> i & 1获得其结点的类型，0当前这个结点不存在
            // 不存在就创建一个结点，指针加加，然后赋给s，更新存在
            if( son[p][x >> i & 1] == 0 ){
                son[p][x >> i & 1] = ++ idx;
            }
            // p指向当前新创建的这个结点或者已经存在的点
            p = son[p][x >> i & 1];

        }
        // for走完，一个数的二进制位在trie中就构建完成
    }



    public static int query( int x ){
        // res记录当前数x的最大异或对是几。p遍历指针
        int res = 0 , p = 0 ;
        // 查询同样从最高位开始查有没有跟x相对应的异或对
        for( int i = 30 ; i >= 0 ; i-- ){
            // s结点的类型，看一下x的第i位是0还是1
            int s = x >> i & 1;
            // temp记录这个结点的相反情况
            int temp = s == 0 ? 1 : 0 ;
            // 如果有x对应位的异或点，
            if( son[p][temp] != 0 ){

                res += 1 << i ;
                // p遍历指针就指向这个结点
                p = son[p][temp];
            }else p = son[p][s] ;//没有，就只能指向相同的结点
        }
        // for走完，就找到一个跟x异或之后最大的值
        return res ;
    }
}
