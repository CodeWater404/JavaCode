package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-13-15:53
 * @Function Description ：65.不用加减乘除做加法
 */
public class _65NoAddSubtractMultiplyAndDoAddition {
    class Solution {
        public int add(int a, int b) {
        /*
        没有进位的加法相当于异或运算，有进位的相当于与运算然后左移1位。
        最后的和就是两者相加，直到进位为0
        */
            while( b != 0 ){
                // c记录进位情况
                int c = ( a & b ) << 1;
                // 进行一轮加法运算
                a ^= b;
                // b更新剩余进位
                b = c;
            }
            return a;
        }
    }
}
