package acwing.basic.chapter1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-10-11:13
 * @Function Description ：归并排序
 */
public class _787MergeSort {

    public static int N = 100010;
    public static int[] q = new int[N];
    public static int[] temp = new int[N];

    // public static void merge_sort( int[] q , int l , int r ){
    //     if( l >= r ) return ;
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

    //     for(  i = l , j = 0 ; i <= r ; i ++ , j++ ) q[i] = temp[j];
    // }

    // 另外一种去掉传数组的,其实差不多，可能考虑到语言性能方面的原因？
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