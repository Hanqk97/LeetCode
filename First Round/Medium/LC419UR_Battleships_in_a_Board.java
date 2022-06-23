package Medium;

/*
iven an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.
Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
Example 1:
Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
Output: 2
Example 2:
Input: board = [["."]]
Output: 0
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is either '.' or 'X'.
 */
public class LC419UR_Battleships_in_a_Board {
    public int countBattleships(char[][] board) {
        //枚举起点
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((board[i][j] == 'X') && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.')) {
                    count++;
                }
            }
        }
        return count;
    }

//    遍历扫描
//    public int countBattleships(char[][] board) {
//        int row = board.length;
//        int col = board[0].length;
//        int ans = 0;
//        for (int i = 0; i < row; ++i) {
//            for (int j = 0; j < col; ++j) {
//                if (board[i][j] == 'X') {
//                    board[i][j] = '.';
//                    for (int k = j + 1; k < col && board[i][k] == 'X'; ++k) {
//                        board[i][k] = '.';
//                    }
//                    for (int k = i + 1; k < row && board[k][j] == 'X'; ++k) {
//                        board[k][j] = '.';
//                    }
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        LC419UR_Battleships_in_a_Board A = new LC419UR_Battleships_in_a_Board();
        char[][] t1 = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(A.countBattleships(t1));
    }
}
