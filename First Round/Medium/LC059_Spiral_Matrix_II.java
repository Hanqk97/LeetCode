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
public class LC059_Spiral_Matrix_II {
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
//        int[][] m = new int[n][n];
//        int direction = 1;//1 left go right, 2  go down, 3 right go left, 4 up
//        int row = 0, column = 0;
//        for(int i = 1; i<= n*n; i++){
//            if(n == 1){
//                m[0][0] = 1;
//                break;
//            }
//            m[row][column] = i;
//            if(direction == 1){
//                if(column < n-1){
//                    if(m[row][column+1] != 0){
//                        direction = 2;
//                        if(row < n-1){
//                            row ++;
//                        }
//                    }else{
//                        column ++;
//                    }
//                }else{
//                    direction = 2;
//                    if(row < n-1){
//                        row ++;
//                    }
//                }
//            }else if(direction == 2){
//                if(row < n-1){
//                    if(m[row+1][column] != 0){
//                        direction = 3;
//                        if(column > 0){
//                            column --;
//                        }
//                    }else{
//                        row ++;
//                    }
//                }else{
//                    direction = 3;
//                    if(column > 0){
//                        column --;
//                    }
//                }
//            }else if(direction == 3){
//                if(column > 0){
//                    if(m[row][column-1] != 0){
//                        direction = 4;
//                        if(row > 0){
//                            row --;
//                        }
//                    }else{
//                        column --;
//                    }
//                }else{
//                    direction = 4;
//                    if(row > 0){
//                        row --;
//                    }
//                }
//            }else if(direction == 4){
//                if(row > 0){
//                    if(m[row-1][column] != 0){
//                        direction = 1;
//                        if(column < n-1){
//                            column ++;
//                        }
//                    }else{
//                        row --;
//                    }
//                }else{
//                    direction = 1;
//                    if(column < n-1){
//                        column ++;
//                    }
//                }
//            }
//        }
//        return m;
    }

    public static void main(String[] args) {
        LC059_Spiral_Matrix_II a = new LC059_Spiral_Matrix_II();
        a.generateMatrix(4);
    }
}
