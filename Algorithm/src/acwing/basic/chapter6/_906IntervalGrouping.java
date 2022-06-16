package acwing.basic.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ： CodeWater
 * @create ：2022-06-16-14:30
 * @Function Description ：
 * 906.区间分组
 */

class Range{
    int l , r;
    public Range( int l , int  r ){
        this.l = l;
        this.r = r;
    }
}

public class _906IntervalGrouping {

    public static int N = 100010 , n ;
    // 所有区间
    public static Range[] range = new Range[N];

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in ) );
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt( str[0] );
        for( int i = 0 ; i < n ; i++ ){
            str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]) , r = Integer.parseInt(str[1]);
            range[i] = new Range(l , r);
        }

        // 对于左端点进行排序
        Arrays.sort(range , 0 , n , (o1 , o2) -> o1.l - o2.l );

        // 小根堆维护所有组（默认自然排序），对于每一组堆中存储的是组中最大的一个右端点
        Queue<Integer> heap = new PriorityQueue<>();
        // 从小到大枚举所有区间
        for( int i = 0 ; i < n ; i++ ){
            Range r = range[i];
            // 当前堆中为空或者堆顶的值大于等于当前区间的左端点（有交集），说明要新开一个组，放入堆中
            if( heap.isEmpty() || heap.peek() >= r.l ) heap.offer(r.r);
            else{
                //否则无交集，可以放入该组，也就是更新该组的一个右端点(删除堆顶，加入新区间的右端点)
                heap.poll(); //poll取值并弹出堆顶元素
                heap.offer(r.r);
            }
        }

        System.out.println( heap.size() );
    }
    
}
