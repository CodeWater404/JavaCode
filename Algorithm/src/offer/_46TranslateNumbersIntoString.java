package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-02-14:36
 * @Function Description ：46.把数字翻译成字符串
 */
public class _46TranslateNumbersIntoString {
    class Solution {

        public int translateNum(int num) {
            String s = String.valueOf( num );
            // 用两个变量优化开一个dp数组，因为当前状态之和i-2， i-1状态有关
            int a0 = 1 , b1 = 1;
            for( int i = 2 ; i <= s.length()  ; i++ ){
                // 截取2位数字
                String temp = s.substring( i - 2 , i );
// c保存当前i这种状态时翻译的种类数。下面用三元运算符判断是否在合理区间，不在说明只能单个翻译
                int c = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? a0 + b1 : a0;
                b1 = a0 ;
                a0 = c;
            }

            return a0;
        }
    }
}
