package Medium;
/*
Input
["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
Output
[null, 8, 11, 12]

Explanation
NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
 */

public class LC304_Range_Sum_Query_2D_Immutable {

    private  int[][] sumMatrix;

    public LC304_Range_Sum_Query_2D_Immutable(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        sumMatrix = new int[row+1][column+1];
        for(int i=0; i<row;i++){
            for(int j=0; j<column;j++){
                sumMatrix[i][j+1] = sumMatrix[i][j]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1; i<=row2;i++){
            sum+=sumMatrix[i][col2+1]-sumMatrix[i][col1];
        }
        return sum;
    }
}
/*
Official Solution

|O X X|
|X A B|
|X C D|
S(O,D)=S(O,C)+S(O,B)−S(O,A)+D

|O X X X X|
|X G X X F|
|X X A X B|
|X X X X X|
|X E C X D|

S(A,D)=S(O,D)−S(O,E)−S(O,F)+S(O,G)

class NumMatrix {

    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length > 0) {
            preSum = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    preSum[i+1][j+1] = preSum[i][j+1] + preSum[i+1][j] - preSum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
}

 */
