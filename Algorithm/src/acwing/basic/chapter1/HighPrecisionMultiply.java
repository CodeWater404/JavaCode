package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author ： CodeWater
 * @create ：2022-03-16-9:29
 * @Function Description ：
 * 高精度乘法
 */
public class HighPrecisionMultiply {
    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        BigInteger a = new BigInteger( br.readLine() );
        BigInteger b = new BigInteger( br.readLine() );
        
        System.out.println( a.multiply( b ) );
    }
}
