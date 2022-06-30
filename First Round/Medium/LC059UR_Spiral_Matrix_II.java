package Medium;
/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:
Input: n = 1
Output: [[1]]
Constraints:
1 <= n <= 20
 */
public class LC059UR_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int row = 0,column = 0;
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex = 0;
        int cur = 1;
        while (cur<=n*n){
            matrix[row][column] = cur;
            cur ++;
            int nextRow = row+direction[directionIndex][0], nextColumn = column+direction[directionIndex][1];
            if (nextRow < 0 || nextRow >= row || nextColumn < 0 || nextColumn >= column || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4;//顺时针到下一个方向
            }
            row += direction[directionIndex][0];
            column += direction[directionIndex][1];
        }
        return matrix;
    }
}
