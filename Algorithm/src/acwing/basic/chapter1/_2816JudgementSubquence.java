package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-20-20:25
 * @Function Description ：
 * 判断子序列：a是否是b的一部分，在b中可以不连续
 */
public class _2816JudgementSubquence {
    public static int N = 100010;
    public static int[] a = new int[N];
    public static int[] b = new int[N];
    public static int n , m ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        n = Integer.parseInt( str[0] ) ; m = Integer.parseInt( str[1] );
        str = br.readLine().split( " " );
        for( int i = 0 ; i < n ; i++ ) a[i] = Integer.parseInt( str[i] );
        str = br.readLine().split(" ");
        for( int i = 0 ; i < m ; i++ )b[i] = Integer.parseInt( str[i] );
        int i = 0 , j = 0 ;
//  i是扫描小的序列a ； j是扫描大的序列b
        while( i < n && j < m ){
//            相等的时候，i才走。因为要判断a是否在b中。
            if( a[i] == b[j] ) i++;
            /*注意这里b的指针，不管ij是否相等都要往右移动，如果加个else就是
            不等才移相等不移，这就错了，因为一个元素不能复用。等不等都得移
            */
            j++;
        }
//i=n的时候，说明子序列a已经全部在b中了;如果退出while另外一种j=m，说明a不在b中
        if( i == n )System.out.println( "Yes" );
        else System.out.println( "No" );
    }
}
