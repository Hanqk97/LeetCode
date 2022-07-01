package Medium;
/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
Example 1:
Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:
Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.
Follow up:
Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
 */

public class LC289_Game_of_Life {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int column = board[0].length;
        boolean[][] mark = new boolean[row][column];

        for(int i = 0; i < row; i++){
            for(int j = 0; j<column; j++){
                if(board[i][j]==1){
                    mark[i][j] = true;
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<column;j++){
                int neighbor = liveNeighbor(mark,i,j);
                if(board[i][j]==1){
                    if(neighbor<2 || neighbor>3){
                        board[i][j]=0;
                    }
                }else{
                    if(neighbor==3){
                        board[i][j]=1;
                    }
                }
            }
        }
    }

    private int liveNeighbor(boolean[][] mark, int rowIndex, int columnIndex) {
        int row = mark.length;
        int column = mark[0].length;
        int liveNeighborNum = 0;

        if ((rowIndex - 1) >= 0) {//check up row
            if ((columnIndex - 1 >= 0 && mark[rowIndex - 1][columnIndex - 1])) {
                liveNeighborNum++;
            }
            if ((columnIndex + 1) < column && mark[rowIndex - 1][columnIndex + 1]) {
                liveNeighborNum++;
            }
            if (mark[rowIndex - 1][columnIndex]) {
                liveNeighborNum++;
            }
        }

        //check this row
        if ((columnIndex - 1 >= 0 && mark[rowIndex][columnIndex - 1])) {
            liveNeighborNum++;
        }
        if ((columnIndex + 1) < column && mark[rowIndex][columnIndex + 1]) {
            liveNeighborNum++;
        }

        if ((rowIndex + 1) < row) {//check down row
            if ((columnIndex - 1) >= 0 && mark[rowIndex + 1][columnIndex - 1]) {
                liveNeighborNum++;
            }
            if ((columnIndex + 1) < column && mark[rowIndex + 1][columnIndex + 1]) {
                liveNeighborNum++;
            }
            if (mark[rowIndex + 1][columnIndex]) {
                liveNeighborNum++;
            }


        }

        return liveNeighborNum;
    }

    /*
    Official Solution
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};//0 dead, 1 live, -1 previous live

        int rows = board.length;
        int cols = board[0].length;

        // 遍历面板每一个格子里的细胞
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                // 对于每一个细胞统计其八个相邻位置里的活细胞数量
                int liveNeighbors = 0;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            // 相邻位置的坐标
                            int r = (row + neighbors[i]);
                            int c = (col + neighbors[j]);

                            // 查看相邻的细胞是否是活细胞
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1)) {
                                liveNeighbors += 1;
                            }
                        }
                    }
                }

                // 规则 1 或规则 3
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    // -1 代表这个细胞过去是活的现在死了
                    board[row][col] = -1;
                }
                // 规则 4
                if (board[row][col] == 0 && liveNeighbors == 3) {
                    // 2 代表这个细胞过去是死的现在活了
                    board[row][col] = 2;
                }
            }
        }

        // 遍历 board 得到一次更新后的状态
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] > 0) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

     */
    public static void main(String[] args) {
        int[][] t1 = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        LC289_Game_of_Life a = new LC289_Game_of_Life();
        a.gameOfLife(t1);
        for(int i = 0; i< t1.length;i++){
            for(int j=0; j<t1[0].length;j++){
                System.out.print(t1[i][j]+",");
            }
            System.out.println();
        }
    }

}
