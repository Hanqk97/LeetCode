package Easy;//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function
// to search target in nums. If target exists, then return its index. Otherwise, return -1.
//You must write an algorithm with O(log n) runtime complexity.
//Example 1:
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
//Example 2:
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
//Constraints:
//1 <= nums.length <= 104
//-104 < nums[i], target < 104
//All the integers in nums are unique.
//nums is sorted in ascending order.

public class LC207_Binary_Search {
    public int search(int[] nums, int target) {
        int lowIndex = 0;
        int highIndex = nums.length-1;

        while(lowIndex <= highIndex){
            int curIndex = (lowIndex+highIndex)/2;
            if(nums[curIndex] == target){
                return curIndex;
            }else if(nums[curIndex]>target){
                highIndex = curIndex - 1;
            }else{
                lowIndex = curIndex + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] t1 = {9};
        int tar1 = 9;
        int[] t2 = {-1,0,3,5,9,12};
        int tar2 = 2;

        LC207_Binary_Search a = new LC207_Binary_Search();
        System.out.println(a.search(t1,tar1));
        System.out.println(a.search(t2,tar2));
    }
}

// T(log n), S(1)
