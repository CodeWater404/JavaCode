package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-05-16:56
 * @Function Description ：58.翻转单词顺序
 */
public class _58_1FlipWordOrder {
    class Solution {
        public String reverseWords(String s) {
            // trim取出首尾的空格
            String[] str = s.trim().split(" ");
            StringBuilder res = new StringBuilder();
            for( int i = str.length - 1 ; i >= 0 ; i-- ){
                if(str[i].equals("")) continue;
                res.append(str[i] + " " );

            }
            return res.toString().trim();
        }
    }
}
