package acwing.basic.chapter1;

import java.util.Scanner;
/**
 * @author ： CodeWater
 * @create ：2022-03-04-17:38
 * @Function Description ：快速排序
 */
public class QuickSort {
    public static int N = 100010;
    public static int[] q = new int[N];
//    public static int[N] q;
    public static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for( int i = 0 ; i < n ; i++ ){
            q[i] = sc.nextInt();
        }
        quick_sort( q , 0 , n - 1 );
        
        for( int i = 0 ; i < n ; i++)
            System.out.print(q[i] + " ");
    }

//    快速排序
    public static void quick_sort( int[] arr , int l , int r){
        //当单个区间长度为1的时候就可以不用再分了
        if( l >= r ) return ;
        //定义2个左右遍历指针指针i  j 分界点x(取区间中点)
        int i = l - 1 , j = r + 1 , x = q[(i + j ) / 2];
        while(i < j){
            //当当前指针所指的元素小于分界点的时候，i往后走
            do i++; while( q[i] < x );
            //当当前指针所指的元素大于分界点的时候，j往前走
            do j--; while( q[j] > x );
            //如果两个指针没有相遇过，交换2个位置的元素
            //交换，也不知道java有没有提供直接交换的方法（C++有swap）
            if(i < j ) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        //递归左右区间
        quick_sort( q,  l , j );
        quick_sort( q , j + 1 , r );
    }
}
