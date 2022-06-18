package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:30
 * @Function Description ：291.蒙德里安的梦想
 */
public class _291MondranDream {
    public static int N = 12 , M = 1 << N ;
    public static int n , m ;
    // f[i][j]看第i列上一列往当前列扩展出来的是哪些行
    public static long[][] f = new long[N][M];
    public static boolean[] st = new boolean[M];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );
        m = Integer.parseInt( str[1] );
        while( n != 0 || m != 0 ){
            for( int i = 0 ; i < N ; i++ )
                Arrays.fill( f[i] , 0 );

            //枚举所有的状态是不是不存在连续奇数个0
            for( int i = 0 ; i < 1 << n ; i++ ){
                //假设成立
                st[i] = true;
                //当前这一段连续0的个数
                int cnt = 0;

                for( int j = 0 ; j < n ; j++ ){
                    // 当前是1，上一段已经截止
                    if( (i >> j & 1) == 1 ){
                        // 判断上一段0是不是有连续奇数个 有，不合法
                        if( (cnt & 1) == 1 ) st[i] = false;
                        // 连续的一段已经结束，cnt重置
                        cnt = 0;
                    }else{
                        //如果是0
                        cnt++;
                    }
                }
                // 判断最后一段0的个数  如果是奇数
                if( (cnt & 1) == 1 ) st[i] = false;

            }
            //dp
            f[0][0] = 1;

            // 枚举所有的列
            for( int i = 1 ; i <= m ; i++ ){
                // 枚举所有的状态
                for( int j = 0 ; j < 1 << n ; j++ ){
                    // 枚举所有第i-1列的所有状态
                    for( int k = 0 ; k < 1 << n ; k++ ){
                        // 满足两个条件才能转移
                        if( (j & k ) == 0 && st[j | k] )
                            f[i][j] += f[i - 1][k];
                    }
                }
            }

            //输出答案
            System.out.println( f[m][0] );

            // 获取下一次的输入
            str = br.readLine().split(" ");
            n = Integer.parseInt( str[0] );
            m = Integer.parseInt( str[1] );
        }
    }

}
