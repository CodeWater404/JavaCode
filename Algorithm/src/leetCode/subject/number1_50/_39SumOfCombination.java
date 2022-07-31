package leetCode.subject.number1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-07-31-22:10
 * @Function Description ：39.组合总和
 */
public class _39SumOfCombination {
    class Solution {
        /**因为要考虑所有的方案，所以不能优化。
         爆搜：因为每个数可以重复选择。所以搜索的时候枚举当前数，考虑选0次的情况，
         1次的情况，2次的情况等等。。。

         */
        //  res答案  path搜索一次的方案
        private List<List<Integer>> res = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            //从第一个数开始枚举
            dfs( candidates , 0 , target );
            return res;
        }

        // 每选用一个数就把target对应相减，减到0，可以组合
        public void dfs( int[] cs , int u , int target ){
            // 枚举到可以组合target.把当前遍历的路径添加到res中
            if( target == 0 ){
                // ================注意这里的语法！！不能写res.add(path);==================
                res.add( new ArrayList(path) );
                return;
            }
// 如果枚举到最后一个数，但是还没有组合target，直接返回
            if( u == cs.length ) return ;

            //枚举。可以选0个，但是条件是不要超过target
            for( int i = 0 ; cs[u] * i <= target ; i++ ){
                // 第一次选0个不加，直接到下一层
                dfs(cs , u + 1 , target - cs[u] * i );
                // 第二次及以后选择了有数字，加到方案中.所以在递归之后加入
                path.add(cs[u]);
            }

            // 恢复现场:清空path
            for( int i = 0 ; cs[u] * i <= target ; i++ ){
                path.remove( path.size() - 1 );
            }

        }
    }
}
