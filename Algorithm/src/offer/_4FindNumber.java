package offer;

/**
 * @author ： CodeWater
 * @create ：2022-03-10-13:56
 * @Function Description ：剑指 Offer 04. 
 * 二维数组中的查找
 */
public class _4FindNumber {
    //暴力
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //可能为空
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 )
            return false;
        int rows = matrix.length , cols = matrix[0].length;
        for(int i = 0 ; i < rows ; i++ ){
            for( int j = 0 ; j < cols ; j++ ){
                if( matrix[i][j] == target ) return true;

            }

        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        //方法二:从每一行的末尾开始判断
        if( matrix == null || matrix.length == 0 || matrix[0].length == 0 )
            return false;

        int rows = matrix.length , cols = matrix[0].length;
        int row = 0 , col = cols - 1;
        while( row < rows && col >= 0 ){
            if( matrix[row][col] == target ) return true;
            else if( matrix[row][col] > target ) col--;
            else row++; //这一行的值小于target;往下一行找
        }
        return false;
    }
}
