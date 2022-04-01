package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author ： CodeWater
 * @create ：2022-04-01-17:41
 * @Function Description ：表达式求值（栈）
 * 给定一个表达式，其中运算符仅包含 +,-,*,/（加 减 乘 整除），可能包含括号，请你求出表达式的最终值。
 *
 * 注意：
 *
 * 数据保证给定的表达式合法。
 * 题目保证符号 - 只作为减号出现，不会作为负号出现，例如，-1+2,(2+2)*(-(1+1)+2) 之类表达式均不会出现。
 * 题目保证表达式中所有数字均为正整数。
 * 题目保证表达式在中间计算过程以及结果中，均不超过 231−1。
 * 题目中的整除是指向 0 取整，也就是说对于大于 0 的结果向下取整，例如 5/3=1，对于小于 0 的结果向上取整，例如 5/(1−4)=−1。
 * C++和Java中的整除默认是向零取整；Python中的整除//默认向下取整，因此Python的eval()函数中的整除也是向下取整，在本题中不能直接使用。
 * 输入格式
 * 共一行，为给定表达式。
 *
 * 输出格式
 * 共一行，为表达式的结果。
 *
 * 数据范围
 * 表达式的长度不超过 105。
 *
 * 输入样例：
 * (2+2)*(1+1)
 * 输出样例：
 * 8
 */
public class _3302ExpressionEvaluation {
    /*流程：
   1.从左至右遍历表达式，数字和（直接压入对应的栈，只不过数字需要另外的判别是不是多位数，如
   983，这个时候就需要把这个983从字符串中处理出来。
   2.如果是）说明已经有一个（）里面的表达式子部分可以处理出结果，一直进行运算，直到对应的（
   出现，并把它弹出栈，运算结果存入数字栈。
   3.如果是运算符，只有在运算符栈不空并且栈顶不是（，栈顶优先级大于当前运算符优先级，才进行
   运算；当后两种情况不满足时退出while，压入运算符栈
   4. 最后检查运算符栈是否还有元素
   5.输出数字栈栈顶，即结果
   */
    public static int N = 100010;
    // 数字栈
    public static Stack<Integer> num = new Stack<>();
    // 运算符栈
    public static Stack<Character> op = new Stack<>();
    // 运算符优先级map
    public static HashMap<Character , Integer> pr = new HashMap<>();

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        char[] str = br.readLine().toCharArray();
        // 初始化运算符优先级
        pr.put( '+' , 1 ); pr.put( '-' , 1 );
        pr.put( '*' , 2 ); pr.put( '/' , 2 );

        // 遍历输入的表达式
        for( int i = 0 ; i < str.length ; i++ ){
            // 获得当前表达式字符
            char c  = str[i];
            // 第一种情况,数字
            if( Character.isDigit( c ) ){
                // 如果不是个位数,需要继续1取,直到这个多位数取完
                int x = 0 , j = i ;
                while( j < str.length && Character.isDigit( str[j] ) )
                    x = x * 10 + str[j++] - '0';
                //   压入数字栈,i跳过多位数
                num.push( x );
                i = j - 1;
            }
            // 第二种情况(,直接入运算符栈
            else if( c == '(' )op.push( c );
            else if( c == ')' ){
                // 第三种情况),说明正好有个()可以进行运算,一直处理到(并把它弹出,运算结果存数字栈
                while( op.peek() != '(' ) eval();
                op.pop();//退出while时，op栈顶就是（
            }else{
// 第四种情况，运算符，运算符栈不空并且栈顶不是（，栈顶优先级大于当前运算符优先级，就进行运算
                while( !op.isEmpty() && op.peek() != '(' && pr.get(op.peek()) >= pr.get(c) )
                    eval();
                //直接操作到上面三个条件中的后两个条件为止，然后把这个运算符压入运算符栈
                op.push( c );
            }
        }

        // 如果运算符栈还有元素，继续进行运算
        while( !op.isEmpty() ) eval();
        // 最后输出结果
        System.out.println( num.pop() );

    }

    // 运算符操作
    public static void eval(){
        // 先取出b，后是a
        int b = num.pop() , a = num.pop();
        // 取运算符
        char c = op.pop();
        // 运算结果
        int x ;
        // 进行相应的运算
        if( c == '+' ) x = a + b;
        else if( c == '-' ) x = a - b;
        else if( c == '*' ) x = a * b;
        else x = a / b;
        // 最后把结果压入数字栈
        num.push( x );
    }
}
