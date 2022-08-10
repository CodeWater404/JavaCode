package leetCode.subject.number51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-08-10-21:49
 * @Function Description ：76.子集
 */
public class _78Subset {
    class Solution {
        /**用二进制0/1来表示每一个元素选或者不选。比如有三个元素，用000到111表示。
         也就是选择的方案数在0到2的n次方减1种。
         011：选择第一个和第二个元素
         */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            // 枚举从0到2^n -1  （1左移n位，在这里表示i小于n个元素表示下的最大二进制数）
            for( int i = 0 ; i < 1 << n ; i++ ){
                // 方案数共有2^n种，从小枚举每一种
                List<Integer> path = new ArrayList<>();
                // 看看第j位（也就是看i对应在nums中第j个元素）有没有选择过
                for( int j = 0 ; j < n ; j++ ){
                    // i右移j位，第j位1表示选择改位
                    if( (i >> j & 1) == 1 )
                        // 添加改元素
                        path.add(nums[j]);
                }
                // 内层循环完，就是一种方案
                res.add(path);
            }
            return res;
        }
    }
}
