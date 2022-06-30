package Medium;

import java.util.LinkedList;

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.
Example 1:
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
Constraints:
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
Follow up:
A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
public class LC073_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        int rowNum = matrix.length;
        int columnNum = matrix[0].length;
        LinkedList<int[]> list = new LinkedList<>();

        for(int m = 0; m<rowNum;m++){
            for (int n = 0;n<columnNum;n++){
                if(matrix[m][n] == 0){
                    int [] cur  = {m,n};
                    list.add(cur);
                }
            }
        }

        for(int i = 0; i<list.size(); i++){
            int[] cur = list.get(i);
            giveZero(matrix,cur[0],cur[1]);
        }

    }

    private void giveZero(int[][] target, int rowIndex, int columnIndex){
        for(int c = 0 ; c < target[0].length; c++){
            target[rowIndex][c] = 0;
        }

        for(int r = 0; r < target.length; r++){
            target[r][columnIndex] = 0;
        }
    }
    /*
    Official Solution 01 行列标记
    我们可以用两个标记数组分别记录每一行和每一列是否有零出现。
    具体地，我们首先遍历该数组一次，如果某个元素为 00，那么就将该元素所在的行和列所对应标记数组的位置置为 true。最后我们再次遍历该数组，用标记数组更新原数组即可。
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    时间复杂度：O(mn)，其中 m 是矩阵的行数，n 是矩阵的列数。我们至多只需要遍历该矩阵两次。
    空间复杂度：O(m+n)，其中 m 是矩阵的行数，n 是矩阵的列数。我们需要分别记录每一行或每一列是否有零出现。

     */

    /*
    Official Solution 02 使用两个标记变量
    用矩阵的第一行和第一列代替方法一中的两个标记数组，以达到 O(1)O(1) 的额外空间。但这样会导致原数组的第一行和第一列被修改，无法记录它们是否原本包含 00。因此我们需要额外使用两个标记变量分别记录第一行和第一列是否原本包含 00。
    在实际代码中，我们首先预处理出两个标记变量，接着使用其他行与列去处理第一行与第一列，然后反过来使用第一行与第一列去更新其他行与列，最后使用两个标记变量更新第一行与第一列即可。
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
    复杂度分析
    时间复杂度：O(mn)，其中 m 是矩阵的行数，n 是矩阵的列数。我们至多只需要遍历该矩阵两次。
    空间复杂度：O(1)。我们只需要常数空间存储若干变量。
    */

    public static void main(String[] args) {
        int[][] t1 = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        LC073_Set_Matrix_Zeroes a = new LC073_Set_Matrix_Zeroes();
        a.setZeroes(t1);
        for(int i = 0; i< t1.length;i++){
            for(int j=0; j<t1[0].length;j++){
                System.out.print(t1[i][j]+",");
            }
            System.out.println();
        }
    }
}
