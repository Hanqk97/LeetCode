package Easy;
/*
An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).
Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.
Example 1:
Input: img = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[0,0,0],[0,0,0],[0,0,0]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the points (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Example 2:
Input: img = [[100,200,100],[200,50,200],[100,200,100]]
Output: [[137,141,137],[141,138,141],[137,141,137]]
Explanation:
For the points (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
For the points (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
For the point (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
Constraints:
m == img.length
n == img[i].length
1 <= m, n <= 200
0 <= img[i][j] <= 255
 */

public class LC661_Image_Smoother {
    public int[][] imageSmoother(int[][] img) {
        int h = img.length;
        int l = img[0].length;
        int[][] smoother = new int[h][l];

        for(int i=0;i<h;i++){
            for(int j=0;j<l;j++){
                int num = 1;
                int total = img[i][j];
                //mid line
                if(j>0){
                    total += img[i][j-1];
                    num++;
                }
                if(j<(l-1)){
                    total += img[i][j+1];
                    num++;
                }
                // up line
                if(i>0){
                    if(j>0){
                        total += img[i-1][j-1];
                        num++;
                    }
                    if(j<(l-1)){
                        total += img[i-1][j+1];
                        num++;
                    }
                    total += img[i-1][j];
                    num++;
                }
                //down line
                if(i<(h-1)){
                    if(j>0){
                        total += img[i+1][j-1];
                        num++;
                    }
                    if(j<(l-1)){
                        total += img[i+1][j+1];
                        num++;
                    }
                    total += img[i+1][j];
                    num++;
                }
                smoother[i][j] = total/num;
            }
        }

        return smoother;
    }
//
//    Official Solution
//    public int[][] imageSmoother(int[][] img) {
//        int m = img.length, n = img[0].length;
//        int[][] ret = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int num = 0, sum = 0;
//                for (int x = i - 1; x <= i + 1; x++) {
//                    for (int y = j - 1; y <= j + 1; y++) {
//                        if (x >= 0 && x < m && y >= 0 && y < n) {
//                            num++;
//                            sum += img[x][y];
//                        }
//                    }
//                }
//                ret[i][j] = sum / num;
//            }
//        }
//        return ret;
//    }
//

    public static void main(String[] args) {
        int[][] t1 = {{100,200,100},{200,50,200},{100,200,100},{100,200,300}};
        LC661_Image_Smoother  a = new LC661_Image_Smoother();
        a.imageSmoother(t1);
    }
}
