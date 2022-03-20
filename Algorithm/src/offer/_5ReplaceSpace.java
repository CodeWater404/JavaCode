package offer;

/**
 * @author ： CodeWater
 * @create ：2022-03-11-17:28
 * @Function Description ：
 * 剑指 Offer 05. 替换空格
 */
public class _5ReplaceSpace {
    public String replaceSpace(String s) {
        int length = s.length();
        char[] temp = new char[ length * 3 ];
        int j = 0;
        for( int i = 0  ; i < s.length() ; i++ ){
            char a = s.charAt(i);
            if( a == ' ' ){
                temp[j++] = '%';
                temp[j++] = '2';
                temp[j++] = '0';
            } else{
                temp[j++] = a;
            }

        }
        String str = new String( temp , 0 , j );
        return str;
    }
}
