package Medium;

import java.util.Arrays;

/*
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return compute the researcher's h-index.
According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.
If there are several possible values for h, the maximum one is taken as the h-index.

Example 1:
Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:
Input: citations = [1,3,1]
Output: 1
Constraints:
n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000
 */
public class LC274_H_Index {
    public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int h = 0;
            int len = citations.length;
            //根据 h 指数的定义，如果已经遍历的 jj 个元素都大于等于 jj，则 h 指数至少为 jj。其中最大的 jj 的值即为 h 指数。
            for(int i = len-1, j=1; i>=0 && citations[i]>=j;--i,++j){
                h=j;
            }

            return h;
    }

    public static void main(String[] args) {
        int[] t1 = {3,0,6,1,5};
        int[] t2 = {1,3,1};


        LC274_H_Index a = new LC274_H_Index();
        System.out.println(a.hIndex(t1));
    }
}
