package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-15-10:28
 * @Function Description ：
 * 数的三次方根：
 *  对于本题来说：不管什么数，取三次方之后，一定会在（-10000,10000）之间，所以这就是边界
 */
public class TheCubicRootOfANumber {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        double x = Double.parseDouble( br.readLine() );
        double l = -10000 , r = 10000;
        while( r - l > 1e-8 ){
            double mid = (l + r ) / 2;
            if( mid * mid * mid >= x ) r = mid;
            else l = mid ;
        }
//        取6位小数，注意是printf，不是println
        System.out.printf( "%.6f\n" , l );
        // System.out.println( "%.6f\n" , l );
    }
}
