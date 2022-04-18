package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-10-11:13
 * @Function Description ：归并排序
 * 给定你一个长度为 n 的整数数列。
 *
 * 请你使用归并排序对这个数列按照从小到大进行排序。
 *
 * 并将排好序的数列按顺序输出。
 *
 * 输入格式
 * 输入共两行，第一行包含整数 n。
 *
 * 第二行包含 n 个整数（所有整数均在 1∼109 范围内），表示整个数列。
 *
 * 输出格式
 * 输出共一行，包含 n 个整数，表示排好序的数列。
 *
 * 数据范围
 * 1≤n≤100000
 * 输入样例：
 * 5
 * 3 1 2 4 5
 * 输出样例：
 * 1 2 3 4 5
 */
public class _787MergeSort {

    public static int N = 100010;
    public static int[] q = new int[N];
    public static int[] temp = new int[N];

//y:    这种把q数组写成全局，传不传q都一样
    // public static void merge_sort( int[] q , int l , int r ){
    //     if( l >= r ) return ;
//    这里的mid是取得下标。   而快排就直接取得中间值作为枢纽
    //     int mid = l + r >> 1;
    //     merge_sort( q , l , mid );
    //     merge_sort( q , mid + 1 , r );
    //     int k = 0 , i = l , j = mid + 1;
    //     while( i <= mid && j <= r ){
    //         if( q[i] <= q[j] ) temp[k++] = q[i++];
    //         else temp[k++] = q[j++];
    //     }

    //     while( i <= mid ) temp[k++] = q[i++];
    //     while( j <= r ) temp[k++] = q[j++];
//i是从l开始遍历直到r结束！！！！！！！！！！！！！！！！！！！！！！！！！！
    //     for(  i = l , j = 0 ; i <= r ; i ++ , j++ ) q[i] = temp[j];
    // }

    // 其余：另外一种去掉传数组的,其实差不多，可能考虑到语言性能方面的原因？
    public static void merge_sort(int l,int r){
        if(l==r) return;

        int mid=l+r>>1;
        merge_sort(l,mid);
        merge_sort(mid+1,r);

        int[] h=new int[r-l+1];
        int idx=0;
        int i=l;
        int j=mid+1;
        while(i<=mid&&j<=r){
            if(q[i]<=q[j]) h[idx++]=q[i++];
            else h[idx++]=q[j++];
        }

        while(i<=mid) h[idx++]=q[i++];
        while(j<=r) h[idx++]=q[j++];

        for(int k=0;k<idx;k++){
            q[k+l]=h[k];
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in) );
        int n = Integer.parseInt( br.readLine() );
        String[] str = br.readLine().split(" ");

        for( int i = 0 ; i < n ; i++ ) q[i] = Integer.parseInt( str[i] );

        // merge_sort( q , 0 , n - 1 );
        merge_sort( 0 , n - 1 );
        // 不能用增强for，不然会输出后面多余的
        for( int i = 0 ; i < n ; i++ ) System.out.print( q[i] + " " );

    
    }
}
