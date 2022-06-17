package acwing.basic.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-06-17-13:55
 * @Function Description ：907.区间覆盖
 */

class Range{
    int l , r;
    public Range(int l , int r ){
        this.l = l ;
        this.r = r ;
    }
}
public class _907IntervalCoverage {

    public static int N = 100010 , n ;
    public static Range[] range = new Range[N];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
        String[] str = br.readLine().split(" ");
        // 目标区间st到ed
        int st = Integer.parseInt(str[0]) , ed = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        for( int i = 0 ; i < n ; i++ ){
            str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0] ) , r = Integer.parseInt(str[1]);
            range[i] = new Range(l , r);
        }

        // 对左端点排序
        Arrays.sort(range , 0 , n , (o1, o2) -> o1.l - o2.l );

        // res答案
        int res = 0;
        // 标志是否找到答案的
        boolean success = false ;

        // 从前往后 枚举每个区间的左端点
        for( int i = 0 ; i < n ; i++ ){
            // 用双指针来扫描，j表示当前区间，r表示当前能覆盖的一个区间右端点最大值
            int j = i , r = (int)-2e9;
            // j在区间数量之内，同时当前区间j的左端点要小于目标区间st的左端点
            while( j < n && range[j].l <= st ){//其实就是做的图解中的第二步
                // 更新r
                r = Math.max(r , range[j].r);
                j++;
            }

            // 无解情况：最大值右端点都小于目标区间的左端点
            if( r < st ){
                res = -1;
                break;
            }

            // 加上从while中选择的一个区间数
            res++;

            // 如果最大值右端点已经大于目标区间的右端点，说明已经找到答案
            if( r >= ed ){
                success = true;
                break;
            }

            // 还没有找到能覆盖区间的数量，把目标区间的左端点更新为当前选择区间的右端点
            st = r;

            // j-1因为：j跳出循环后是第一个不满足条件的点，j-1保证下次循环从j开始，不会区间没有漏洞
            i = j - 1;
        }
    
    /*如果不标记，会出错。对于目标区间（1,5），给定两个区间（-1,2），（2,4），可以看出明显无法
    覆盖目标区间，但是按照算法流程下来，res会加到2，在循环中不走if( r >= ed )，而是执行完for
    跳出后输出。所以需要success标记是否找到答案！
    */
        if(!success ) res = -1;
        System.out.println( res );

    }
    
}
