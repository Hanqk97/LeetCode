package Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
Example 1:
Input: rowIndex = 3
Output: [1,3,3,1]
Example 2:
Input: rowIndex = 0
Output: [1]
Example 3:
Input: rowIndex = 1
Output: [1,1]
 */
public class LC119_Pascal_s_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> row = new LinkedList<>() ;
        row.add(1);
        triangle.add(row);
        if(rowIndex==0) return triangle.get(0);

        for(int i = 1; i<=rowIndex;i++){
            List<Integer> pre = triangle.get(i-1);
            List<Integer> cur = new ArrayList<Integer>(i+1);
            cur.add(1);
            for (int j=1; j<(i+1);j++){
                if(j==i){
                    cur.add(1);
                }else{
                    cur.add(pre.get(j-1)+pre.get(j));
                }
            }
            triangle.add(cur);
        }

        return triangle.get(rowIndex);
    }

//    Official Solution Optimization
//    public List<Integer> getRow(int rowIndex) {
//        List<Integer> row = new ArrayList<Integer>();
//        row.add(1);
//        for (int i = 1; i <= rowIndex; ++i) {
//            row.add(0);
//            for (int j = i; j > 0; --j) {
//                row.set(j, row.get(j) + row.get(j - 1));
//            }
//        }
//        return row;
//    }

    public static void main(String[] args) {
        LC119_Pascal_s_Triangle_II a = new LC119_Pascal_s_Triangle_II();
        System.out.println(a.getRow(3));
    }
}
