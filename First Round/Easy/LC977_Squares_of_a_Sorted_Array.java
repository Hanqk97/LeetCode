package Easy;

import java.lang.reflect.Array;
import java.util.Arrays;

//Given an integer array nums sorted in non-decreasing order, return an array of
// the squares of each number sorted in non-decreasing order.
// Example 1:
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
// Example 2:
// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]
// Constraints:
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums is sorted in non-decreasing order.
// Follow up: Squaring each element and sorting
// the new array is very trivial, could you find an O(n) solution using a different approach?
public class LC977_Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] nums) {
        for(int i=0; i<nums.length; i++){
            nums[i] = nums[i]*nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
//T(n)=O(nlogn)
    public static void main(String[] args) {
        LC977_Squares_of_a_Sorted_Array a = new LC977_Squares_of_a_Sorted_Array();
        int[] t1 = {-4,-1,0,3,10};
        int[] t2 = {-7,-3,2,3,11};
        int[] r1 = a.sortedSquares(t1);
        int[] r2 = a.sortedSquares(t2);
        for(int i : r1){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i : r2){
            System.out.print(i+" ");
        }
    }
}
