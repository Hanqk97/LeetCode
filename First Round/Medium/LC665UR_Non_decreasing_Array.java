package Medium;
/*
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

Example 1:
Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.

Constraints:
n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105
 */
public class LC665UR_Non_decreasing_Array {
    public boolean checkPossibility(int[] nums) {
        // 数组个数小于2个 一定可以
        int numsSize = nums.length;
        if (numsSize < 3) {
            return true;
        }

        // 思路如下：
        // 如果出现 a[i] > a[i+1]   改变一个数 就面临两种选择
        // 1. 把a[i]变大
        // 2. 把a[i+1] 变小
        // 这两种选择其实是有依据的 需要比较a[i-1] 与 a[i+1]的值
        // eg.  ... 1 4 3 ...   只能选择把4变小   ... 3 4 1 ... 只能选择把1变大
        // 改变完之后，记录改变次数，再检测是否升序
        // 如果次数大于1，至少改了两次 返回false

        // 先让前两个有序
        // 因为没有左边没有数 所以对于前两个数来说，最佳选择就是吧 a[0] 变小
        int changeCount = 0;
        if (nums[0] > nums[1]) {
            nums[0] = nums[1];
            changeCount++;
        }

        for (int i = 1; i < numsSize - 1; i++) {
            int right = nums[i+1];
            if (nums[i] > right) {
                changeCount++;
                if (changeCount > 1) {
                    // 后面不用再看了
                    return false;
                }
                int left = nums[i-1];
                if (left > right) {
                    nums[i+1] = nums[i];
                } else {
                    nums[i] = left;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] t1 = {5,7,1,8};

        LC665UR_Non_decreasing_Array a = new LC665UR_Non_decreasing_Array();
        System.out.println(a.checkPossibility(t1));
    }
}
