package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-17-13:15
 * @Function Description ：
 * 差分
 */
public class Difference {
    // 数据范围
    public static int N = 100010;
    // n个数
    public static int n ;
    // m次操作
    public static int m ;
    // a前缀和数组 ， b差分数组
    public static int[] a = new int[N];
    public static int[] b = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        n = Integer.parseInt( str[0] );
        m = Integer.parseInt( str[1] );
        str = br.readLine().split( " " );
        for( int i = 1 ; i <= n ; i++ ){
            // a、b数组都是从1开始记录数据；但str是从0下标开始有数据的
            a[i] = Integer.parseInt( str[i - 1] );
            // 构造差分数组
            insert( i , i , a[i] );
        }
        //m次操作
        while( m-- > 0 ){
            str = br.readLine().split( " " );
            int l = Integer.parseInt( str[0] );
            int r = Integer.parseInt( str[1] );
            int c = Integer.parseInt( str[2] );
            // 构造差分数组
            insert( l , r , c );
        }
        // 输出答案
        for( int i = 1 ; i <= n ; i++ ){
            //a是b的前缀和数组;这样看b[i] = a[i] +a[i - 1]
            a[i] = a[i - 1] + b[i];
            System.out.print( a[i] + " " );
        }
    }

    // 差分操作
    public static void insert( int l , int r , int c ){
        b[l] += c;
        b[r + 1] -= c;
    }
}
