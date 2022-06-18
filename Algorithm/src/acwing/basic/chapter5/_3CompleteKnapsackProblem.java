package acwing.basic.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-13:46
 * @Function Description ：3.完全背包问题
 */
public class _3CompleteKnapsackProblem {
    // //----------------------------朴素三层for二维----------------

// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.BufferedReader;

// public class Main{
//     public static int N = 1010;
//     // n种物品 ， 背包体积为m
//     public static int n , m ;
//     // v体积   w价值
//     public static int[] v = new int[N];
//     public static int[] w = new int[N];
//     // 状态表示数组： 第一维下标表示第几种物品；第二维表示背包容量是多少，数组值表示当前状态的最大值
//     public static int[][] f = new int[N][N];

//     public static void main( String[] args ) throws IOException{
//         BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
//         String[] str = br.readLine().split(" ");
//         n = Integer.parseInt( str[0] );
//         m = Integer.parseInt( str[1] );
//         for( int i = 1 ; i <= n ; i++ ){
//             str = br.readLine().split(" ");
//             v[i] = Integer.parseInt( str[0] );
//             w[i] = Integer.parseInt( str[1] );

//         }

//         //遍历n种物品
//         for( int i = 1 ; i <= n ; i++ ){
//             // j表示当前状态下的假设总背包容量
//             for( int j = 0 ; j <= m ; j++ ){
//                 // 当前第i种物品选择了k个
//                 for( int k = 0 ; k * v[i] <= j ; k++ ){
//                     f[i][j] = Math.max( f[i][j] , f[i - 1][j - k * v[i]] + k * w[i] );
//                 }
//             }
//         }
//         // 输出最后的状态，即答案。对于n种物品，背包体积为m的能存储的最大值。！！
//         System.out.println( f[n][m] );
//     }
// }


//---------------------------优化一层for----------------
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.io.BufferedReader;

// public class Main{
//     public static int N = 1010;
//     public static int n , m ;
//     public static int[] v = new int[N];
//     public static int[] w = new int[N];
//     public static int[][] f = new int[N][N];

//     public static void main( String[] args ) throws IOException{
//         BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
//         String[] str = br.readLine().split(" ");
//         n = Integer.parseInt( str[0] );
//         m = Integer.parseInt( str[1] );
//         for( int i = 1 ; i <= n ; i++ ){
//             str = br.readLine().split(" ");
//             v[i] = Integer.parseInt( str[0] );
//             w[i] = Integer.parseInt( str[1] );

//         }

//         for( int i = 1 ; i <= n ; i++ ){
//             for( int j = 0 ; j <= m ; j++ ){
//                 //优化看图解
//                 f[i][j] = f[i - 1][j];
//                 if( j >= v[i] )
//                     f[i][j] = Math.max( f[i][j] , f[i][j - v[i]] + w[i] );
//             }
//         }
//         System.out.println( f[n][m] );

//     }
// }


// ---------------------------终极：优化一层for+一维----------------

    public static int N = 1010;
    public static int n, m;
    public static int[] v = new int[N];
    public static int[] w = new int[N];
    public static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for (int i = 1; i <= n; i++) {
            str = br.readLine().split(" ");
            v[i] = Integer.parseInt(str[0]);
            w[i] = Integer.parseInt(str[1]);
        }

        for (int i = 1; i <= n; i++) {
            // 这里改成从v[i]开始，顺序
            for (int j = v[i]; j <= m; j++) {
                //原来是f[i][j] = f[i - 1][j]; //取出一维后是f[j] = f[j];恒等直接删除整句
//                if( j >= v[i] )
//                     f[i][j] = Math.max( f[i][j] , f[i][j - v[i]] + w[i] );
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);

            }
        }
        System.out.println(f[m]);
    }
}
