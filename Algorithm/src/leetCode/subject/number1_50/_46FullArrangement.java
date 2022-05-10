package leetCode.subject.number1_50;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-05-10-15:28
 * @Function Description ：46
 */
public class _46FullArrangement {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            List<Integer> output = new ArrayList<>();
            for( int i : nums ) output.add( i );

            int n = nums.length;
            dfs( n , output , 0 , ans );

            return ans;
        }

        public void dfs(  int n , List<Integer> output , int u , List<List<Integer>> ans ){
            if( u == n ) ans.add( new ArrayList<Integer>(output) );
            for( int i = u ; i < n ; i++ ){
                Collections.swap( output , u , i );
                dfs( n , output , u + 1 , ans );
                Collections.swap( output , u , i );
            }
        }

    }
}
