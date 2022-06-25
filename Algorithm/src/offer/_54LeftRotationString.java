package offer;

/**
 * @author ： CodeWater
 * @create ：2022-06-25-21:54
 * @Function Description ：54.左旋转字符串
 */
public class _54LeftRotationString {
    public String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for( int i = n ; i < n + s.length() ; i++ ){
            // 写这个if会让i一直在for里面循环，oom
            // if( i >= s.length() ) i = i % s.length();
            res.append( s.charAt( i % s.length() ) );
        }

        return res.toString();
    }
}
