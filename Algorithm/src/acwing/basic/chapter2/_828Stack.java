package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-03-25-14:31
 * @Function Description ：826模拟栈（栈顶指针是先加在赋值；不是先赋值在加；也就是说存储元素的下标从1开始）
 * 实现一个栈，栈初始为空，支持四种操作：
 *
 * push x – 向栈顶插入一个数 x；
 * pop – 从栈顶弹出一个数；
 * empty – 判断栈是否为空；
 * query – 查询栈顶元素。
 * 现在要对栈进行 M 个操作，其中的每个操作 3 和操作 4 都要输出相应的结果。
 *
 * 输入格式
 * 第一行包含整数 M，表示操作次数。
 *
 * 接下来 M 行，每行包含一个操作命令，操作命令为 push x，pop，empty，query 中的一种。
 *
 * 输出格式
 * 对于每个 empty 和 query 操作都要输出一个查询结果，每个结果占一行。
 *
 * 其中，empty 操作的查询结果为 YES 或 NO，query 操作的查询结果为一个整数，表示栈顶元素的值。
 *
 * 数据范围
 * 1≤M≤100000,
 * 1≤x≤109
 * 所有操作保证合法。
 *
 * 输入样例：
 * 10
 * push 5
 * query
 * push 6
 * pop
 * query
 * pop
 * empty
 * push 4
 * query
 * empty
 * 输出样例：
 * 5
 * 5
 * YES
 * 4
 * NO
 */
public class _828Stack {
    public static int N = 100010;
    // 栈
    public static int[] stk = new int[N];
    // 栈顶指针
    public static int tt = 0;
    // m次查询
    public static int m ;

    public static void main(String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        m = Integer.parseInt( str[0] );

        while( m-- > 0 ){
            str = br.readLine().split( " " );
            String op = str[0];
            int x ;
            if( op.equals( "push" ) ){
                x = Integer.parseInt( str[1] );
                // 栈顶指针先加加,然后给当前指针指向的位置赋值（即入栈）
                stk[++tt] = x;
            }else if( op.equals( "pop" ) ){
                // 栈顶指针减减，在数组中并没有被删除，后面要再插入的时候会覆盖，不用考虑
                tt--;
            }else if( op.equals( "empty" ) ){
// tt大于0才有元素存在，如果等于0也是无元素。因为他是先加在赋值；不是先赋值在加；也就是说
// 存储元素的下标从1开始
                if( tt > 0 ) System.out.println( "NO" );
                else System.out.println( "YES" );
            }else if( op.equals( "query" ) ){
                System.out.println( stk[tt] );
            }
        }


    }
}
