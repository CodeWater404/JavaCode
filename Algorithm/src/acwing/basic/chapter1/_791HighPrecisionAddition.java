package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author ： CodeWater
 * @create ：2022-03-15-11:24
 * @Function Description ：
 * 高精度加法：java有大整数类型，所以不用特别处理
 * （当然也可以自己模拟，但是我懒）
 */
public class _791HighPrecisionAddition {
    public static void main(String[] args) throws IOException {
//        3200ms
//        Scanner sc = new Scanner( new BufferedInputStream( System.in ) );
//        BigInteger a = sc.nextBigInteger();
//        BigInteger b = sc.nextBigInteger();


        // 2080ms
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //可以直接构造
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        System.out.println(a.add(b));

    }
}
