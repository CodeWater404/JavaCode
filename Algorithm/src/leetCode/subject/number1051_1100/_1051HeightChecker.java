package leetCode.subject.number1051_1100;

/**
 * @author ： CodeWater
 * @create ：2022-03-05-16:16
 * @Function Description ：1051高度检查器
 * https://leetcode-cn.com/problems/height-checker/
 */
public class _1051HeightChecker {
    //count不能定义为静态，否则过不了
//    public static int count = 0;
    
    public static void main(String[] args){
        int[] a = {5 , 1 , 2 , 3 , 4 };
        System.out.println(heightChecker(a));

    }
    
    public static int heightChecker(int[] heights){
        // count定义静态变量就不能过，局部变量就可以
        int count = 0 ;
        //heights.length是在（1,100）范围内，不是固定的，要直接写固定的数字才行！
        int[] temp = new int[110 ];
        for(int height : heights){
            //统计每个元素出现的次数
            temp[height]++;

        }
        // 遍历temp数组，因为元素大小范围在1--100之间，所以从1开始。
        for(int i = 1 , j = 0 ; i < temp.length ; i++){
            // temp[i]，i就是桶中存放的元素的值，temp[i]是元素的个数
            // temp[i]-- 就是每次取出一个，一直取到没有元素，成为空桶
            while(temp[i] -- > 0 ){
                // heights[j]是题目给定的元素，i是temp中的元素（下标是数字，内容是出现了几次）
                if( heights[j++] != i  ) count ++;
            }
        }
        return count;
    }
}
