package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-16-9:50
 * @Function Description ：
 * 前缀和
 */
public class _795PrefixAnd {
    //数据范围
    public static int N = 100010;
    //a原数组；s前缀和数组
    public static int[] a = new int[N];
    public static int[] s = new int[N];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );

        int n = Integer.parseInt( str[0] );
        int m = Integer.parseInt( str[1] );
        str = br.readLine().split( " " );


        for( int i = 1 ; i <= n ; i++ ) a[i] = Integer.parseInt( str[i - 1] );
        for( int i = 1 ; i <= n ; i++ ) s[i] = s[ i - 1] + a[i];

        while( m-- > 0 ){
            str = br.readLine().split( " " );

            int l = Integer.parseInt( str[0] ) , r = Integer.parseInt( str[1] );
            //s r减掉l前面的和就是（l，r）之间的和
            System.out.println( s[r] - s[l - 1] );
        }

    }
}
