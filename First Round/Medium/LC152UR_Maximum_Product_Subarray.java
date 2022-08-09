package Medium;
/*
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class LC152UR_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }
    /*
    标签：动态规划
    遍历数组时计算当前最大值，不断更新
    令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
    由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
    当负数出现时则imax与imin进行交换再进行下一步计算。
    时间复杂度：程序一次循环遍历了 nums，故渐进时间复杂度为 O(n)。
    空间复杂度：优化后只使用常数个临时变量作为辅助空间，与 nn 无关，故渐进空间复杂度为 O(1)

     */



    public static void main(String[] args) {
        LC152UR_Maximum_Product_Subarray a = new LC152UR_Maximum_Product_Subarray();
        int[] t1 = {-2,3,-4};
        System.out.println(a.maxProduct(t1));
    }
}
