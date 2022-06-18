package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:31
 * @Function Description ：338.计数问题
 */
public class _338CountingProblem {
    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt( str[0] ) , b = Integer.parseInt( str[1] );
        while( a != 0 && b != 0 ){
            //a>b则交换次序
            if( a > b ){
                int temp = a;
                a = b ; b = temp;
            }

            //统计每一位上出现的次数
            for( int i = 0 ; i < 10 ; i++ ){
                System.out.print( count(b , i) - count( a - 1 , i) + " " ) ;
            }
            System.out.println();

            //获取下一次的输入
            str = br.readLine().split(" ");
            a = Integer.parseInt( str[0] ); b = Integer.parseInt( str[1] );
        }
    }

    // 统计1-n中，x出现的次数
    public static int count( int n , int x ){
        // n=0直接返回结果
        if( n == 0 ) return 0;

        //抽取n的每一位
        ArrayList<Integer> num = new ArrayList<>();
        while( n != 0 ){
            num.add( n % 10 );
            n /= 10;
        }

        //n重新赋值为它有的位数
        n = num.size();

        //res答案
        int res = 0;
//从最高位枚举,但是0不会出现在最高位，所以三目运算判断下,如果是0从第二位开始，不是0最高位开始
        for( int i = n - 1 - (x == 0 ? 1 : 0); i >= 0 ; i-- ){
            //第一种情况时0到-1，最高开始的枚举，不存在，所以需要从小于n-1位开始
            if( i < n - 1 ){
                // 第一种情况次数相加
                res += get( num , n - 1 , i + 1 ) * power10( i );

                if( x == 0 ) res -= power10(i);
            }

            //第二种情况的第一类是0，不看；算第二类,后面数字几位构成的数+1
            if( num.get(i) == x )res += get(num , i - 1 , 0 ) + 1;
                // 第二种情况的第三类，加上10的i次方
            else if( num.get(i) > x ) res += power10( i );
        }

        return res;
    }

    // 求l高位到r低位这个区间组成的数字是多少
    public static int get(ArrayList<Integer> num , int l , int r ){
        int res = 0;
        for( int i = l ; i >= r ;i-- ){
            res = res * 10 + num.get(i);
        }
        return res;
    }

    //求10的x次方
    public static int power10( int x ){
        int res = 1;
        while( x-- != 0 ) res *= 10;
        return res;
    }

}
