package Easy;

import java.util.Arrays;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Example 2:
Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
public class LC217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
    /*
    时间复杂度：O(NlogN)，其中 N 为数组的长度。需要对数组进行排序。
    空间复杂度：O(logN)，其中 N 为数组的长度。注意我们在这里应当考虑递归调用栈的深度。
     */

    /*
    Official Solution Hash Map
     public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }
    时间复杂度：O(N)，其中 N 为数组的长度。
    空间复杂度：O(N)，其中 N 为数组的长度。
     */
    public static void main(String[] args) {
        LC217_Contains_Duplicate a =  new LC217_Contains_Duplicate();
        int[] t1 = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(a.containsDuplicate(t1));
    }
}
