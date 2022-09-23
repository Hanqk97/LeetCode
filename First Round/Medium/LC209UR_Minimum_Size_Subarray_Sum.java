package Medium;

//Given an array of positive integers nums and a positive integer target,
// return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
// of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
//Example 1:
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem constraint.
//Example 2:
//Input: target = 4, nums = [1,4,4]
//Output: 1
//Example 3:
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
//Constraints:
//1 <= target <= 109
//1 <= nums.length <= 105
//1 <= nums[i] <= 104
public class LC209UR_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static void main(String[] args) {
        int[] t1 = {2,3,1,2,4,3};
        int[] t2 = {1,2,3,4,5};
        LC209UR_Minimum_Size_Subarray_Sum a = new LC209UR_Minimum_Size_Subarray_Sum();
        System.out.println(a.minSubArrayLen(7,t1));
        System.out.println(a.minSubArrayLen(11,t2));
    }
}
