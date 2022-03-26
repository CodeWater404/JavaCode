package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-26-16:31
 * @Function Description ：滑动窗口（单调队列）
 * 单调队列
 * 如果当前队尾数比当前要加入进来这个数大，那就把它从队列中删除，这样使得这个队列保持
 * 一个单调增的性质，那每次要求最小的数只要输出队头即可。（最大值同理）
 * 
 * 给定一个大小为 n≤106 的数组。
 *
 * 有一个大小为 k 的滑动窗口，它从数组的最左边移动到最右边。
 *
 * 你只能在窗口中看到 k 个数字。
 *
 * 每次滑动窗口向右移动一个位置。
 *
 * 以下是一个例子：
 *
 * 该数组为 [1 3 -1 -3 5 3 6 7]，k 为 3。
 *
 * 窗口位置	最小值	最大值
 * [1 3 -1] -3 5 3 6 7	-1	3
 * 1 [3 -1 -3] 5 3 6 7	-3	3
 * 1 3 [-1 -3 5] 3 6 7	-3	5
 * 1 3 -1 [-3 5 3] 6 7	-3	5
 * 1 3 -1 -3 [5 3 6] 7	3	6
 * 1 3 -1 -3 5 [3 6 7]	3	7
 * 你的任务是确定滑动窗口位于每个位置时，窗口中的最大值和最小值。
 *
 * 输入格式
 * 输入包含两行。
 *
 * 第一行包含两个整数 n 和 k，分别代表数组长度和滑动窗口的长度。
 *
 * 第二行有 n 个整数，代表数组的具体数值。
 *
 * 同行数据之间用空格隔开。
 *
 * 输出格式
 * 输出包含两个。
 *
 * 第一行输出，从左至右，每个位置滑动窗口中的最小值。
 *
 * 第二行输出，从左至右，每个位置滑动窗口中的最大值。
 *
 * 输入样例：
 * 8 3
 * 1 3 -1 -3 5 3 6 7
 * 输出样例：
 * -1 -3 -3 -3 3 3
 * 3 3 5 5 6 7
 */
public class _154SlidingWindow {
    public static int N = 1000010;
    // a存储题目给定元素；q单调队列存储的a数组里面值的下标，队列的下标是数组里面对应的值
    public static int[] a = new int[N];
    public static int[] q = new int[N];
    // n个元素，k队列长度
    public static int n , k ;

    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        n = toInt( str[0] ) ; k = toInt( str[1] );
        //  System.out.println( n + " " + k );
        int hh = 0 , tt = -1 ;
        str = br.readLine().split( " " );
        // System.out.println( str.length );
        for( int i = 0 ; i < n ; i++ )a[i] = toInt( str[i] );



        for( int i =  0 ; i < n ; i++ ){
  /*首先判断当前队头元素还是不是在窗口的内部，如果不在的话就要删掉
         i此时是窗口右侧的端点，i - k + 1得到的是窗口左侧的端点，这样就可以判断
         此时队列的头部时候还在窗口内
         */
            if( hh <= tt && q[hh] < i - k + 1 ) hh++;
            //当队列不空，并且队尾元素比当前要加入进来的元素大，那就把他删掉
            while( hh <=  tt && a[q[tt]] >= a[i] ) tt--;
            // a的下标存储进队列
            q[++tt] = i;

            //当窗口满足k个数时，才输出最小值
            if( i >= k - 1 ) System.out.print( a[q[hh]] + " " );
        }
        System.out.println();

        // 这里要记得重新初始化队列长度
        hh = 0 ; tt = -1 ;
        for( int i = 0 ; i < n ; i++ ){
            if( hh <= tt && q[hh] < i - k + 1 ) hh++;
            //当队列不空，并且队尾元素比当前要加入进来的元素小，那就把他删掉
            while( hh <= tt && a[q[tt]] <= a[i] ) tt--;
            q[++tt] = i;

            if( i >= k - 1 ) System.out.print( a[q[hh]] + " ");
        }

    }

    public static int toInt( String str ){
        return Integer.parseInt( str );
    }
}
