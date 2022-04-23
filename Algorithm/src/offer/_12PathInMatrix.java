package offer;

/**
 * @author ： CodeWater
 * @create ：2022-04-08-15:45
 * @Function Description ：12.矩阵中的路径
 */
public class _12PathInMatrix {
    class Solution {
        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // 从二维每个位置依次深搜
                    if (dfs(board, words, i, j, 0)) return true;
                }
            }
            // 循环结束还没有遍历到就是没有这个字母
            return false;
        }

        // i， j当前在board中遍历到的位置， k当前words中遍历到的下标
        public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            // 不在范围内或者字母不等
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) return false;
            // 遍历到最后一个字母符合条件
            if (k == word.length - 1) return true;
            // 不是最后一个字母，标记改为已经被遍历过
            board[i][j] = '!';
            // 往下上左右一次深搜
            boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1);
            // 回溯，恢复之前的状态
            board[i][j] = word[k];
            // 返回遍历 的结果
            return res;
        }
    }
}
