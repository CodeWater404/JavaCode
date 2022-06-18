package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-13:44
 * @Function Description ：2.01背包
 * 详解：https://www.acwing.com/activity/content/code/content/3219167/
 */
public class _2_01BackpackProblem {
    //----------------朴素二维-----------------
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.BufferedReader;

// public class Main{
//     public static int N = 1010;
//     //n个物品数量  m背包容量
//     public static int n  , m ;
//     // v对应每个物品的体积   w对应每个物品的价值
//     public static int[] v = new int[N];
//     public static int[] w = new int[N];
//     // f(i , j )：只能从前i个物品中选择，选中的总体积不超过j，f(i , j)值就是存储的方案最大值
//     public static int[][] f = new int[N][N];

//     public static void main( String[] args ) throws IOException {
//         BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) ) ;
//         String[] str = br.readLine().split(" ");
//         n = Integer.parseInt( str[0] );
//         m = Integer.parseInt( str[1] );
//         // 初始化物品体积和价值
//         for( int i = 1 ; i <= n ; i++ ){
//             str = br.readLine().split( " " );
//             v[i] = Integer.parseInt( str[0] );
//             w[i] = Integer.parseInt( str[1] );

//         }

//         // 求解f(i , j)每一步的状态
//         for( int i = 1 ; i <= n ; i++ ){
    //j是当前状态下假设的背包体积
//             for( int j = 0 ; j <= m ; j++ ){
//                 // 不选择第i个物品的当前状态最大值由上一个状态得到，因为它是不选择第i个，所以j不变
//                 f[i][j] = f[i - 1][j];
//                 /*选择第i个物品的当前状态最大值：首先减掉当前物品价体积v[i]回到上一个状态
// 的最大值，然后再加上当前物品的价值得到当前物品状态的最大值。但同时，当前状态可能不存在（j<v[i]
// 也就是背包容量不够放物品的时候，所以需要if判断，同时比较选择和不选择第i件物品的最大值得到当前
// 状态的最大值。*/
//                 if( j >= v[i] ) f[i][j] = Math.max( f[i - 1][j] , f[i - 1][j - v[i]]  + w[i] );

//             }
//         }
//         System.out.println( f[n][m] );

//     }
// }



// -----------------优化一维--------------
        public static int N = 1010;
        public static int n , m ;
        public static int[] v = new int[N];
        public static int[] w = new int[N];
        public static int[] f = new int[N];

        public static void main( String[] args ) throws IOException {
            BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
            String[] str = br.readLine().split(" ");
            n = Integer.parseInt( str[0] );
            m = Integer.parseInt( str[1] );
            for( int i = 1 ; i <= n ; i++ ){
                str = br.readLine().split(" ");
                v[i] = Integer.parseInt( str[0] );
                w[i] = Integer.parseInt( str[1] );

            }

            for( int i = 0 ; i <= n ; i++ ){
                for( int j = m ; j >= v[i] ; j-- ){
                    f[j] = Math.max( f[j] , f[j - v[i]] + w[i] );
                }
            }

            System.out.println( f[m] );
        }

}
