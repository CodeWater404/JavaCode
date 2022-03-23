package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-23-12:15
 * @Function Description ：单链表（数组模拟）
 * 实现一个单链表，链表初始为空，支持三种操作：
 *
 * 向链表头插入一个数；
 * 删除第 k 个插入的数后面的数；
 * 在第 k 个插入的数后插入一个数。
 * 现在要对该链表进行 M 次操作，进行完所有操作后，从头到尾输出整个链表。
 *
 * 注意:题目中第 k 个插入的数并不是指当前链表的第 k 个数。例如操作过程中一共插入了 n 个数，则按照插入的时间顺序，这 n 个数依次为：第 1 个插入的数，第 2 个插入的数，…第 n 个插入的数。
 *
 * 输入格式
 * 第一行包含整数 M，表示操作次数。
 *
 * 接下来 M 行，每行包含一个操作命令，操作命令可能为以下几种：
 *
 * H x，表示向链表头插入一个数 x。
 * D k，表示删除第 k 个插入的数后面的数（当 k 为 0 时，表示删除头结点）。
 * I k x，表示在第 k 个插入的数后面插入一个数 x（此操作中 k 均大于 0）。
 * 输出格式
 * 共一行，将整个链表从头到尾输出。
 *
 * 数据范围
 * 1≤M≤100000
 * 所有操作保证合法。
 *
 * 输入样例：
 * 10
 * H 9
 * I 1 1
 * D 1
 * D 0
 * H 6
 * I 3 6
 * I 4 5
 * I 4 5
 * I 3 4
 * D 6
 * 输出样例：
 * 6 4 6 5
 */
public class _826SingleLinkedList {
    public static int N = 100010;
    // 头指针
    public static int head = -1 ;
    // 下标
    public static int idx = 0 ;
    // 存储链表的值
    public static int[] e = new int[N];
    // 存储链表的指针
    public static int[] ne = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        int m = Integer.parseInt( str[0] );

        while( m-- > 0 ){
            str = br.readLine().split( " " );
            int k , x ;
            String op =  str[0] ;
            // if( op == "H" ){//不要用等号判断，string是引用类型！！！
            if( op.equals( "H" ) ){
                x = Integer.parseInt( str[1] );
                add_to_head( x );
            }else if( op.equals( "D" ) ){
                k = Integer.parseInt( str[1] );
                // 第一个插入的
                if( k ==  0 )head = ne[head];
                    // 下标从0开始，所以k应该是k-1。这里必须要写else，不然会出错越界。不知道为啥cpp不用。。。
                else remove( k - 1 );
            }else if( op.equals("I") ){

                k = Integer.parseInt( str[1] );
                x = Integer.parseInt( str[2] );
                add( k - 1 , x );
            }
        }
        // for( int i = head ; i != -1 ; i = ne[i] ) 
        //     System.out.print( e[i] + " " );
        int i = head;
        while (i != -1) {
            System.out.print(e[i] + " ");
            i = ne[i];
        }
    }

    // 头插
    public static void add_to_head( int x ){
        /*x赋给当前下标指向的数组位置，ne赋head，head赋idx后移；idx下标更新*/
        e[idx] = x;
        ne[idx] = head;
        head = idx ;
        idx++;
    }

    public static void add( int k , int x ){
        e[idx] = x ;
        // 把第k个结点指向k+1结点的指针赋给当前这个结点
        ne[idx] = ne[k];
        // k结点的指针指向这个结点；就实现了在k后面插入值
        ne[k] = idx;
        idx++;
    }

    public static void remove( int k ){
// 删除第k个后面的结点就是让k的指针指向第k+2个结点，跳过k+1；
// ne[k]指向k+1，ne[ne[k]]也就是k+2结点了
        ne[k] = ne[ne[k]];
    }
}
