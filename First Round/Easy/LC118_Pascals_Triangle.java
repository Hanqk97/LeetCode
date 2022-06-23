package Easy;
/*
Given an integer numRows, return the first numRows of Pascal's triangle.
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:
Input: numRows = 1
Output: [[1]]
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC118_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> row = new LinkedList<>() ;
        row.add(1);
        triangle.add(row);
        if(numRows==1) return triangle;

        for(int i = 1; i<numRows;i++){
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

        return triangle;
    }

    public static void main(String[] args) {
        LC118_Pascals_Triangle a = new LC118_Pascals_Triangle();
        List<List<Integer>> t1 = a.generate(5);
        for(List<Integer> b : t1){
            for(int c: b){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
