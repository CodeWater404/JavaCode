package offer;

/**
 * @author ： CodeWater
 * @create ：2022-07-09-13:33
 * @Function Description ：45.把数组排成最小的数
 */
public class _45LateTheArrayIntoTheSmallest {
    class Solution {
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for( int i = 0 ; i < nums.length ; i++ ){
                strs[i] = String.valueOf( nums[i] );
            }
            quickSort( strs , 0 , strs.length - 1 );
            StringBuilder res = new StringBuilder();
            for(String s : strs){
                res.append(s);

            }
            return res.toString();
        }

        public void quickSort( String[] strs , int l , int r ){
            if( l >= r ) return ;
            int i = l , j = r  ;
            // 哨兵
            String temp = strs[i];
            while( i < j ){
            /*这里还不能调换位置。。。。字符串x ， y
            x+y > y+x  --->   x > y (compareTo比较的是字典序)
            y+x > x+y  --->   y > x
            */
                // j+l > l + j ---> j > l   j指针减减
                while( (strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j ) j--;
                // i+l < l+i   ---> i < l   i指针加加
                while( (strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j ) i++;
                temp = strs[i];
                strs[i] = strs[j];
                strs[j] = temp;
            }
            // 交换哨兵
            strs[i] = strs[l];
            strs[l] = temp;
            quickSort( strs , l , i - 1 );
            quickSort( strs , i + 1 , r );
        }
    }
}
