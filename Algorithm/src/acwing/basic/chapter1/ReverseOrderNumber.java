package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-14-10:17
 * @Function Description ：
 * 数的范围（二分）
 * 有问题遗留，明天看
 */
public class ReverseOrderNumber {
    public static int N = 100010;
    public static int[] q = new int[N];
    //n个数据，m次查询
    // public static int n , m ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        int n = Integer.parseInt( str[0] );
        int m = Integer.parseInt( str[1] );
        
//        System.out.println("m: " + m );
        
        String[] str1 = br.readLine().split( " " );
        for( int i = 0 ; i < n ; i++ )q[i] = Integer.parseInt( str1[i] );
        //m次查询，这里java也不让直接写m--
        while( m-- > 0 ){
            int x = Integer.parseInt( br.readLine() );
            int l = 0 , r = n - 1;
            while( l < r ){
                //加1是因为上面l到r少一个数；上面写的是下标范围，但不是长度
                int mid = l + r  >> 1 ;
//                这么判断好像是确定范围的下界
                if( q[mid] >= x ) r = mid;
                else l = mid + 1;
            }
            
//            System.out.println("l: " + l + "   r: " + r + "    x: " + x );
            
            //退出二分后，l=r,同时还要看这个数是否和查询的数x相等
            if( q[l] != x ) System.out.println( "-1 -1" );
            else{
//                System.out.println("==x    l: " + l);
       
                //是x，先输出左边界（因为有可能x有多个连续的）
                System.out.print( l + " " );
                //真烦，这里java不让定义l，r
                int ll = 0 , rr = n - 1;

                while( ll < rr ){
//                    不写加1会陷入死循环 为什么要加1？？？？？？？？？？？？？？？？？？？？？？？？？？？
                    int mid = ll + rr + 1 >> 1;
                    /*下面的判断必须要这么写；不能这样写if( q[mid] >= x ) rr = mid ;
                    else ll = mid + 1;
                    不然会边界错误且会死循环。
                    （这样判断好像是确定范围的上界）？？？？？？？？？？？？？？？？？？？？？？？
                    * */
                    if( q[mid] <= x ) ll = mid ;
                    else rr = mid - 1;
                }
//退出后，l=r，但这里不判断是否是x是因为就算没有多个x，只要有一个那就会确定边界
                System.out.println( ll );
            }

        }
    }
}
