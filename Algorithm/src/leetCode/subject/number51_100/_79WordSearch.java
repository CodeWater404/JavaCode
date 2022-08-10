package leetCode.subject.number51_100;

/**
 * @author ： CodeWater
 * @create ：2022-08-10-22:24
 * @Function Description ：79. 单词搜索
 */
public class _79WordSearch {
    class Solution {
        public boolean exist(char[][] board, String word) {
            for( int i = 0 ; i < board.length ; i++ ){
                for( int j = 0 ; j < board[i].length ; j++ ){
                    if( dfs( board , word , 0 , i , j ) ) return true;
                }
            }
            return false;

        }

        // 上有下左四个方向的遍历数组
        int[] dx = {-1 , 0 , 1 , 0 } , dy = {0 , 1 , 0 , -1};

        // u表示遍历的第几个字符
        public boolean dfs(char[][] board , String word , int u , int i , int j ){
            // 剪枝
            if( board[i][j] != word.charAt(u) ) return false;
            // 找到一种解
            if( u == word.length() -1 ) return true;

            char t = board[i][j];
            // 标记当前位置遍历过（用一个题目中不会出现的字符）
            board[i][j] = '-';
            for( int k = 0 ; k < 4 ; k++ ){
                // 下一步
                int a = i + dx[k] , b = j + dy[k];
                if( a < 0 || a >= board.length || b < 0 || b >= board[0].length || board[a][b] == '-' ) continue;
                if( dfs( board , word , u + 1 , a , b ) ) return true;

            }
            // 恢复现场
            board[i][j] = t;
            return false;
        }
    }
}
