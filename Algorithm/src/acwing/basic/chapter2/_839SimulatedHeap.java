package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-04-05-14:41
 * @Function Description ：模拟堆（实现堆的所有功能，三个函数组合使用）
 * 维护一个集合，初始时集合为空，支持如下几种操作：
 *
 * I x，插入一个数 x；
 * PM，输出当前集合中的最小值；
 * DM，删除当前集合中的最小值（数据保证此时的最小值唯一）；
 * D k，删除第 k 个插入的数；
 * C k x，修改第 k 个插入的数，将其变为 x；
 * 现在要进行 N 次操作，对于所有第 2 个操作，输出当前集合的最小值。
 *
 * 输入格式
 * 第一行包含整数 N。
 *
 * 接下来 N 行，每行包含一个操作指令，操作指令为 I x，PM，DM，D k 或 C k x 中的一种。
 *
 * 输出格式
 * 对于每个输出指令 PM，输出一个结果，表示当前集合中的最小值。
 *
 * 每个结果占一行。
 *
 * 数据范围
 * 1≤N≤105
 * −109≤x≤109
 * 数据保证合法。
 *
 * 输入样例：
 * 8
 * I -10
 * PM
 * I -10
 * D 1
 * C 2 8
 * I 6
 * PM
 * DM
 * 输出样例：
 * -10
 * 6
 */
public class _839SimulatedHeap {
    /*本题的模拟堆跟堆排序有点不同；堆排序只用到down操作即可进行操作和删除（最后一个点覆盖），
    但是无法删除第k个；本题采用两个数组来维护记录第k个插入的数和结点是谁，这样就可以随机
    删除第k个数，这个操作实现了一个heapSwap交换函数，直接和最后一个点交换，而不是覆盖了。
1. I x，插入一个数 x；(直接插入到最后，然后不断up使之有序)
2. PM，输出当前集合中的最小值；（输出堆顶）
3. DM，删除当前集合中的最小值（数据保证此时的最小值唯一）；（和最后一个元素交换删除最后一个元素）
4. D k，删除第 k 个插入的数；（第k个数和最后一个数交换，删除最后一个；交换的那个数down或者up一遍，使之有序）
5. C k x，修改第 k 个插入的数，将其变为 x；（修改值之后，down或者up一遍）
PS：为了简化代码，对于每个点的更改情况，我们不写判断，直接down或者up一遍，使之有序，因为他们要么大往下走，要么小往上走，
只会执行其中的一个。
    */

    public static int N = 100010;
    // h堆
    public static int[] h = new int[N];
    /*  ph数组存储的是第j个插入的点在堆中是谁，ph[]=k第j个插入的点在堆中是k;
 hp数组存储的是堆里面的点是第几个插入的点，hp[]=k堆中号点是第k个插入的。
 弄这两个映射是为了在删除和交换结点的时候方便。因为要记录一点是第几个插入的*/
    public static int[] hp = new int[N];
    public static int[] ph = new int[N];
    // length是堆的实际长度，n操作次数，
    // m:当前是插入的第几个数。因为删除的时候要删除第k个插入的数，所以要用个变量存下来
    public static int length , n , m;

    public static void main( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        n = Integer.parseInt(str[0]) ;

        while( n-- > 0 ){
            str = br.readLine().split(" ");
            String op = str[0];
            int k , x;
            if( op.equals("I") ){
                // 插入一个数，直接插到最后，对这个这个数进行up，使堆有序
                x = Integer.parseInt( str[1] );
                length++;
                m++;
                // 映射同时记录，如：ph[m] = length第m个插入的数在堆中是length
                ph[m] = length ; hp[length] = m;
                h[length] = x;
                up( length );
            }else if( op.equals("PM") )System.out.println( h[1] );
            else if( op.equals("DM") ){
                // 删除最小值：堆顶和最后一个数交换，交换后length更新，同时堆顶down
                heapSwap( 1 , length );
                length--;
                down(1);
            }else if( op.equals("D") ){
                // 删除第k个数，和最后一个数交换，然后down（k），up(k)，只会执行一个
                k = Integer.parseInt( str[1] );
                //这里一定要更新k变成在堆中的位置
                k = ph[k];
                heapSwap( k , length );
                length--;
                down(k); up(k);
            }else{
                // 修改第k个插入的数
                k = Integer.parseInt( str[1] );
                x = Integer.parseInt( str[2] );
                // 获取第k个数在堆中的位置，
                k = ph[k];
                // 更改这个位置的值
                h[k] = x;
                // 排序，使之有序
                down(k); up(k);
            }
        }
    }

    // 交换
    public static void swap( int[] arr , int a , int b ){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // 堆中两个元素的交换，同时第几个数的映射也要更改
    public static void heapSwap( int a , int b ){
        // 先改第几个插入的数在堆中的位置，下面的实际就是ph[hp[a]]和ph[hp[b]]的交换
        swap( ph , hp[a] , hp[b] );
        //再改堆中的数到第几个插入树的映射
        swap( hp , a , b );
        // 交换元素值
        swap( h , a , b );
    }

    // down操作，一个数过大，下沉
    public static void down( int u ){
        // t记录最小值
        int t = u ;
        if( u * 2 <= length && h[u * 2] < h[t] )t = u * 2;
        if( u * 2 + 1 <= length && h[u * 2 + 1] < h[t] ) t = u * 2 + 1;
        // u不是最小值，就发生交换；否则不需要
        if( u != t ){
            // 交换两个结点的位置
            heapSwap( u , t );
            // 递归处理t，看是否还比其孩子小
            down( t );
        }
    }

    // up操作，一个数过小，需要上升
    public static void up( int u ){
        // 孩子结点比父结点小
        while( u / 2 > 0 && h[u / 2] > h[u] ){
            // 交换两个结点的位置
            heapSwap( u / 2 , u );
            // 更新u结点的位置
            u /= 2;
        }
    }
}
