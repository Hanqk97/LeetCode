package Medium;
/*
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
Example 1:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:
Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105
 */
public class LC498_Diagonal_Traverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int column = mat.length;
        int row = mat[0].length;
        int total = column*row;
        int[] result = new int[total];

        if(mat == null) return null;//if mat is null

        int direction = 1;
        int nextColumn = 0, nextRow = 0;
        for(int i = 0, columnIndex = 0, rowIndex = 0; i<total;i++){
            result[i] = mat[columnIndex][rowIndex];
            if(direction > 0 ){
                nextColumn = columnIndex - 1;
                nextRow = rowIndex + 1;
            }else{
                nextColumn = columnIndex + 1;
                nextRow = rowIndex - 1;
            }
            if(nextColumn < 0 || nextColumn > column-1 || nextRow < 0 || nextRow > row-1){
                direction *= -1;
                if(direction < 0){
                    if(rowIndex == row-1){
                        columnIndex +=1;
                    }else{
                        rowIndex +=1;
                    }
                }else{
                    if(columnIndex == column-1){
                        rowIndex +=1;
                    }else{
                        columnIndex +=1;
                    }
                }
            }else{
                rowIndex = nextRow;
                columnIndex = nextColumn;
            }
        }

        return  result;

    }
    /*
    Official Solution
    根据题目要求，矩阵按照对角线进行遍历。设矩阵的行数为 mm, 矩阵的列数为 nn, 我们仔细观察对角线遍历的规律可以得到如下信息:
    一共有 m + n - 1 条对角线，相邻的对角线的遍历方向不同，当前遍历方向为从左下到右上，则紧挨着的下一条对角线遍历方向为从右上到左下；
    设对角线从上到下的编号为 i∈[0,m+n−2]：
    当 i 为偶数时，则第 i 条对角线的走向是从下往上遍历；
    当 i 为奇数时，则第 i 条对角线的走向是从上往下遍历；
    当第 i 条对角线从下往上遍历时，每次行索引减 1，列索引加 1，直到矩阵的边缘为止：
    当 i<m 时，则此时对角线遍历的起点位置为 (i,0)；
    当 i≥m 时，则此时对角线遍历的起点位置为 (m−1,i−m+1)；
    当第 i 条对角线从上往下遍历时，每次行索引加 1，列索引减 1，直到矩阵的边缘为止：
    当 i<n 时，则此时对角线遍历的起点位置为 (0,i)；
    当 i≥n 时，则此时对角线遍历的起点位置为 )(i−n+1,n−1)；
    根据以上观察得出的结论，我们直接模拟遍历所有的对角线即可。

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int pos = 0;
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 1) {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    res[pos] = mat[x][y];
                    pos++;
                    x++;
                    y--;
                }
            } else {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    res[pos] = mat[x][y];
                    pos++;
                    x--;
                    y++;
                }
            }
        }
        return res;
    }

    时间复杂度：O(m×n)，其中 m 为矩阵行的数量，n 为矩阵列的数量。需要遍历一遍矩阵中的所有元素，需要的时间复杂度为 O(m×n)。
    空间复杂度：O(1)。除返回值外不需要额外的空间。

     */

    public static void main(String[] args) {
        int[][] t1 = {{1,2,3},{4,5,6},{7,8,9}};
        LC498_Diagonal_Traverse a = new LC498_Diagonal_Traverse();
        int[] r1 = a.findDiagonalOrder(t1);
        for(int i:r1){
            System.out.print(i+", ");
        }
    }
}
