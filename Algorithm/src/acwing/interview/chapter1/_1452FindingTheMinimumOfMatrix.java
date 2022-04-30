//package acwing.interview.chapter1;
//
///**
// * @author ： CodeWater
// * @create ：2022-04-27-16:57
// * @Function Description ：1452寻找矩阵中的极小值
// * 给定一个 n×n 的矩阵，矩阵中包含 n×n 个 互不相同 的整数。
// *
// * 定义极小值：如果一个数的值比与它相邻的所有数字的值都小，则这个数值就被称为极小值。
// *
// * 一个数的相邻数字是指其上下左右四个方向相邻的四个数字，另外注意，处于边界或角落的数的相邻数字可能少于四个。
// *
// * 要求在 O(nlogn) 的时间复杂度之内找出任意一个极小值的位置，并输出它在第几行第几列。
// *
// * 本题中矩阵是隐藏的，你可以通过我们预设的 int 函数 query 来获得矩阵中某个位置的数值是多少。
// *
// * 例如，query(a,b) 即可获得矩阵中第 a 行第 b 列的位置的数值。
// *
// * 注意：
// *
// * 矩阵的行和列均从 0 开始编号。
// * query()函数的调用次数不能超过 (n+2)×⌈log2n⌉+n。
// * 答案不唯一，输出任意一个极小值的位置即可。
// * 数据范围
// * 1≤n≤300，矩阵中的整数在int范围内。
// *
// * 输入样例：
// * [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
// * 输出样例：
// * [0, 0]
// */
//public class _1452FindingTheMinimumOfMatrix {
//    // The query API is defined in the parent class Getvalue:
//// int query(int x, int y);
//// return int means matrix[x][y].
//
//    class Solution extends Getvalue {
//        /*极小值有多个，答案不唯一，随便输出其中的一个即可。因为每个数都不一样，所以一定
//        有解。
//        */
//        public int[] getMinimumValue(int n) {
//            int INF = 0x3f3f3f3f;
//            // lr左右边界
//            int l = 0 , r = n - 1;
//            // 二分
//            while( l < r ){
//                // mid记录中间列
//                int mid = l + r >> 1;
//                // k记录最小值的行号     val记录一列中的最小值，初始无穷大
//                int k = 0 , val = INF;
//                // 遍历中间一列
//                for( int i = 0 ; i < n ; i++ ){
//                    // t记录遍历到的值，   query接口传入行列号，返回该位置的元素值
//                    int t = query(i , mid );
//                    // t小于记录的val值，更新val以及行号
//                    if( t < val ){
//                        val = t;
//                        k = i;
//                    }
//                }
//                // left、right记录中间列上最小值左右的元素大小
//                int left = mid > 0 ? query( k , mid - 1 ) : INF;
//                int right = mid + 1 < n ? query( k , mid + 1 ) : INF;
//
//                // 比较找到的最小值的左右两个位置他们之间的大小关系
//                if(val < left && val < right ) return new int[]{k , mid};//val最小，找到一个解
//                // 缩小左右边界范围
//                if( left < val ) r = mid - 1;
//                else l = mid + 1;
//            }
//
//            // 退出while后，也就只有最后一列了，遍历这最后一列上的所有元素，找到最小值
//            int k = 0 , val = INF;
//            for( int i = 0 ; i < n ; i++ ){
//                // 因为是最后一列所以query第一个参数是i行号变化，第二个列号r就不用再动
//                int t = query( i , r );
//                if( t < val ){
//                    val = t ;
//                    k = i;
//                }
//            }
//            // 最终返回答案
//            return new int[]{k , r};
//        }
//    }
//}
