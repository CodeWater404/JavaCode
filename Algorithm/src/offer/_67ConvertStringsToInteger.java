package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-18-23:53
 * @Function Description ：67.把字符串转换成整数
 */
public class _67ConvertStringsToInteger {
    class Solution {
        public int strToInt(String str) {
            char[] c = str.trim().toCharArray();
            if( c.length == 0 ) return 0;
            // 最大边界bndry = 2147483647 // 10 = 214748364（先除以10方便遍历）
            int res = 0 , boundary = Integer.MAX_VALUE / 10;
            // 遍历直接从1开始，因为要判断第一个是不是符号位
            int i = 1 , sign = 1;
            if( c[0] == '-' ) sign = -1;
                // 过符号判断，到这里又不等于+，说明一开始不是符号位开头，从0开始
            else if( c[0] != '+' ) i  = 0;
            for( int j = i ; j < c.length ; j++ ){
                if(c[j] < '0' || c[j] > '9' ) break;
            /*
            两种情况越界：
            res>bndry  情况一：执行拼接10 * res ≥ 2147483650越界
            res=bndry,x>7  情况二：拼接后是 2147483648 或 2147483649 越界(多一位)
            （x是遍历下一位的数字，拼接上去之后大于MAX_VALUE）
            */
                if( res > boundary || res == boundary && c[j] > '7' )
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                res = res * 10 + ( c[j] - '0' );
            }

            return sign * res;
        }
    }
}
