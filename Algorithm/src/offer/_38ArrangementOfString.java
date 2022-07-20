package offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-07-20-18:46
 * @Function Description ：38.字符串的排列
 */
public class _38ArrangementOfString {
    class Solution {
        List<String > res = new LinkedList<>();
        char[] c;
        public String[] permutation(String s) {
            c = s.toCharArray();
            dfs(0);
            return res.toArray( new String[res.size()] );
        }

        public void dfs( int x ){
            if ( x == c.length - 1){
                res.add( String.valueOf(c));
                return ;
            }
            HashSet<Character> set = new HashSet<>();
            for( int i = x ; i < c.length ; i++ ){
                if( set.contains(c[i]) ) continue;
                set.add( c[i] );
                // 将第i位字符固定在x位
                swap( i , x );
                dfs( x + 1 );
                swap( i , x );
            }
        }

        public void swap(int a , int b){
            char temp = c[a];
            c[a] = c[b];
            c[b] = temp;
        }
    }
}
