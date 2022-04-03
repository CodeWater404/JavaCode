package acwing.basic.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author ： CodeWater
 * @create ：2022-04-03-23:11
 * @Function Description ：食物链（并查集）
 * 动物王国中有三类动物 A,B,C，这三类动物的食物链构成了有趣的环形。
 *
 * A 吃 B，B 吃 C，C 吃 A。
 *
 * 现有 N 个动物，以 1∼N 编号。
 *
 * 每个动物都是 A,B,C 中的一种，但是我们并不知道它到底是哪一种。
 *
 * 有人用两种说法对这 N 个动物所构成的食物链关系进行描述：
 *
 * 第一种说法是 1 X Y，表示 X 和 Y 是同类。
 *
 * 第二种说法是 2 X Y，表示 X 吃 Y。
 *
 * 此人对 N 个动物，用上述两种说法，一句接一句地说出 K 句话，这 K 句话有的是真的，有的是假的。
 *
 * 当一句话满足下列三条之一时，这句话就是假话，否则就是真话。
 *
 * 当前的话与前面的某些真的话冲突，就是假话；
 * 当前的话中 X 或 Y 比 N 大，就是假话；
 * 当前的话表示 X 吃 X，就是假话。
 * 你的任务是根据给定的 N 和 K 句话，输出假话的总数。
 *
 * 输入格式
 * 第一行是两个整数 N 和 K，以一个空格分隔。
 *
 * 以下 K 行每行是三个正整数 D，X，Y，两数之间用一个空格隔开，其中 D 表示说法的种类。
 *
 * 若 D=1，则表示 X 和 Y 是同类。
 *
 * 若 D=2，则表示 X 吃 Y。
 *
 * 输出格式
 * 只有一个整数，表示假话的数目。
 *
 * 数据范围
 * 1≤N≤50000,
 * 0≤K≤100000
 * 输入样例：
 * 100 7
 * 1 101 1 
 * 2 1 2
 * 2 2 3 
 * 2 3 3 
 * 1 1 3 
 * 2 3 1 
 * 1 5 5
 * 输出样例：
 * 3
 */
public class _240FoodChain {
    /*三种动物之间的关系：
用并查集维护，每个点到根结点之间的距离来表示吃与被吃、同类的的关系。
到根结点的距离：
    1：可以吃根结点；被2吃
    2：可以吃1；被根结点吃
    0：与根结点同类，可以吃2，被1吃
    （上述的距离都是模3之后的结果，画一个循环图就很好理解）
综上，所有的点可以归为3大类，但是最终还是合并为一个树。
流程：
初始化时，每个点就是一个单独的集合，所以d距离就是到自己的距离0；
然后根据输入的每句话会进行合并和对假话的判断，最终所有动物都会在一个集合中，判断每个动物属于哪
一类，就是看模3之后的余数。

*/
    public static int N = 50010;
    // p并查集，记录自己所属的根是谁，下标是自己，值是根
    public static int[] p = new int[N];
    // d数组记录结点到根的距离
    public static int[] d = new int[N];
    // n个动物k句话
    public static int n , k ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
        String[] str = br.readLine().split( " " );
        n = Integer.parseInt( str[0] ) ; k = Integer.parseInt( str[1] );
        for( int i = 1 ; i <= n ; i++ ) p[i] = i;//初始化
        int res = 0;//答案
        while( k-- > 0 ){
            str = br.readLine().split( " " );
            int op = Integer.parseInt( str[0] );
            int x = Integer.parseInt( str[1] );
            int y = Integer.parseInt( str[2] );

            // 超出范围，也是假话
            if( x > n || y > n ) res++;
            else{
                int px = find( x ) , py = find( y );
                if( op == 1 ){//1同类
/*假话情况：px==py说明这两个点在一棵树上（就是一类）:但是这两个点到根结点的距离模3之后又不同，
即为假。(d[x] - d[y]) % 3 != 0来判断，xy到根结点的距离相同,dx-dy为0；其实是个简化的写法,朴素：
d[x] % 3 != d[y] % 3.
*/
                    if( px == py && (d[x] - d[y] ) % 3 != 0  ) res++;
                    else if( px != py ){
// xy不是一个集合，把他们合并到一个集合中，x的这个集合的父结点更新为y集合的根结点                    
                        p[px] = py;
/*xy是同类，x这个集合合并到y集合中时，x到本集合根的距离加上本集合到y集合根的距离之后的总和
模3之后是0。也就是d【x】+ ？模3的余数跟d【y】模3的余数相等，进一步优化就是（d【x】+？-d【y】）
模3的值为0，在进一步优化就是？ = d【y】-d【x】。？就是x集合根到y集合根的距离，px。
*/
                        d[px] = d[y] - d[x];
                    }
                }else{//xy不同类
//假话： xy处在同一个集合中（一类），但是：dx%3和（dy+1）%3（朴素）的余数又不等。下面优化
                    if( px == py && (d[x] - d[y] - 1) % 3 != 0 ) res++;
                    else if( px != py ){
                        // 不是同类。x集合合并到y集合中
                        p[px] = py;
// x到新根结点更新，跟上面是一样的分析。朴素：(dx+?)%3= (dy+1)%3(?为x旧根到新根距离)                    
                        d[px] = d[y] + 1 -d[x];
                    }

                }
            }
        }
        System.out.println( res );
    }

    // 返回x结点所属的集合，根
    public static int find( int x ){
        if( p[x] != x ){
//存储x的根是谁。如果不存就是p[x]=find(p[x]);x的父结点p[x]就会被更改，下面计算距离就会出错。
            int t = find(p[x]);
            // x到根结点的距离：自己到父结点的距离加上父结点到根的距离
            d[x] += d[p[x]];
            // x指向根结点，
            p[x] = t;
        }
        return p[x];
    }
}
