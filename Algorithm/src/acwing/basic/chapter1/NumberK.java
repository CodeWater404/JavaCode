package acwing.basic.chapter1;

import java.util.Scanner;

/**
 * @author ： CodeWater
 * @create ：2022-03-04-18:08
 * @Function Description ：第k个数
 * https://www.acwing.com/problem/content/788/
 * 快排每次确定一个最小的数，所以可以用快排优化一下即可。
 */
public class NumberK {
    public static int N = 100010;
    public static int n  , k;
    public static int[] q = new int[N];
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for( int i = 0 ; i < n ; i++ ){
            q[i] = sc.nextInt();
        }
        System.out.println(quickSort(q , 0 , n - 1 , k));
    }

//    其实参数数组写不写无所谓，因为已经静态了；如果是定义的局部数组还是需要写一下然后传入
    public static int quickSort(int[] arr , int l , int r  , int k){
        //找打结果返回
        if( l >= r ) return q[l] ;
        // 每趟排序选取的枢纽不一样，所以l+r/2 ， 而不是ij
        int i = l - 1 , j = r + 1 , x = q[(l + r ) / 2];
        while( i < j ){
            do i++ ; while(q[i] < x);
            do j-- ; while( q[j] > x ) ; 
            if( i < j ){
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        //退出while是，排完一趟，可以确定出一个位置的数，k小于左边长度，说明在左区间内，
        // 继续递归左边区间；否则就在右边区间，注意右边区间传k时要减掉左边区间的长度
        if( k <= j - l + 1) return quickSort( q , l , j ,  k );
        else return quickSort( q , j + 1 , r ,  k - (j - l + 1) );
        
    }
}
