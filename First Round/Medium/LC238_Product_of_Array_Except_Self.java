package Medium;
/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.
Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class LC238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int zeros = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) {
                total *= nums[i];
            }else{
                zeros++;
            }
        }

        for(int i=0; i<nums.length; i++){
            if(zeros>0){
                if(nums[i]==0){
                    if(zeros==1){
                        nums[i] = total;
                    }else{
                        nums[i] = 0;
                    }
                }else{
                    nums[i] = 0;
                }
            }else{
                nums[i] = total/nums[i];
            }
        }

        return  nums;
    }
/*
Official Solution
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }
}

 */
    public static void main(String[] args) {
        int[] t1 = {-1,1,0,-3,3};
        LC238_Product_of_Array_Except_Self a = new LC238_Product_of_Array_Except_Self();
        int[] r1 = a.productExceptSelf(t1);
        for(int i:r1){
            System.out.print(i+",");
        }

    }
}
