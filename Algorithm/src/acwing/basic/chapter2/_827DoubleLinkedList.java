package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-24-14:08
 * @Function Description ：双链表
 * 实现一个双链表，双链表初始为空，支持 5 种操作：
 *
 * 在最左侧插入一个数；
 * 在最右侧插入一个数；
 * 将第 k 个插入的数删除；
 * 在第 k 个插入的数左侧插入一个数；
 * 在第 k 个插入的数右侧插入一个数
 * 现在要对该链表进行 M 次操作，进行完所有操作后，从左到右输出整个链表。
 *
 * 注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。例如操作过程中一共插入了 n 个数，则按照插入的时间顺序，这 n 个数依次为：
 * 第 1 个插入的数，第 2 个插入的数，…第 n 个插入的数。
 *
 * 输入格式
 * 第一行包含整数 M，表示操作次数。
 *
 * 接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：
 *
 * L x，表示在链表的最左端插入数 x。
 * R x，表示在链表的最右端插入数 x。
 * D k，表示将第 k 个插入的数删除。
 * IL k x，表示在第 k 个插入的数左侧插入一个数。
 * IR k x，表示在第 k 个插入的数右侧插入一个数。
 * 输出格式
 * 共一行，将整个链表从左到右输出。
 *
 * 数据范围
 * 1≤M≤100000
 * 所有操作保证合法。
 *
 * 输入样例：
 * 10
 * R 7
 * D 1
 * L 3
 * IL 2 10
 * D 3
 * IL 2 7
 * L 8
 * R 9
 * IL 4 7
 * IR 2 2
 * 输出样例：
 * 8 7 7 3 2 9
 */
public class _827DoubleLinkedList {
    public static int N = 100010;
    // e数组存储当前结点的值；l和r分别表示结点的左右指针
    public static int[] e = new int[N];
    public static int[] l = new int[N];
    public static int[] r = new int[N];
    // idx是当前结点的下标
    public static int idx ;
    public static int m ;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        m = Integer.parseInt( str[0] );
        init();
        while( m-- > 0 ){
            str = br.readLine().split( " " );
            String op = str[0];
            int k , x ;
            if( op.equals( "L" ) ){
                // 在左端插入就是在0号点的右边插入
                x = Integer.parseInt( str[1] );
                add( 0 , x );
            }else if( op.equals( "R" ) ){
                // 在右端插入就是在1号点的左边插入
                x = Integer.parseInt( str[1] );
                add( l[1] , x );
            }else if ( op.equals( "D" ) ){
                k = Integer.parseInt( str[1] );
                //0和1已经用过； idx下标从2开始，第k个就是k+1
                remove( k + 1 );
            }else if( op.equals( "IL" ) ){
                k = Integer.parseInt( str[1] );
                x = Integer.parseInt( str[2] );
                // 在第k个点的左边插入，l[k+1]表示第k-1个点
                add( l[k + 1] , x);
            }else if( op.equals( "IR" ) ){
                // 在第k个点的右边插入
                k = Integer.parseInt( str[1] );
                x = Integer.parseInt( str[2] );
                add( k + 1 , x );
            }
        }

        for( int i = r[0] ; i != 1 ; i = r[i] )
            System.out.print( e[i] + " " );
    }

    // 0号点表示左端点；1号点表示右端点
    public static void init(){
        r[0] = 1;
        l[1] = 0;
        // idx从2开始，因为0、1已经被占用过了
        idx = 2;

    }

    // 实现在k结点的右边插入一个点；如果要是在左边，传入参数为l【k】即可
    public static void add ( int k , int x ){
        // 先存储当前结点的值
        e[idx] = x;
        // 当前结点的左右指针指向k和k的后面一个
        r[idx] = r[k];
        l[idx]= k;
        // 改变原先k后面结点的左指针指向插入的结点
        l[r[k]] = idx;
        // k结点的右指针更新指向当前结点
        r[k] = idx;
        // 插入结点后，idx当前结点的指针记得要后移
        idx++;
    }

    // 删除第k个点
    public static void remove( int k ){
        // k结点的左边结点的右指针指向k的下一个
        r[l[k]] = r[k];
        // k结点的右边结点的左指针指向k的上一个
        l[r[k]] = l[k];
    }
}
