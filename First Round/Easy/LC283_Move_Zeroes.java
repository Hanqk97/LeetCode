package Easy;
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:
Input: nums = [0]
Output: [0]
Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 */

public class LC283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int[] newNums = new int[len];

        for (int i = 0, j = 0; i < len; ++i) {
            if (nums[i] != 0) {
                newNums[j] = nums[i];
                j++;
            }
        }

        for(int i=0; i<len;i++){
            nums[i] = newNums[i];
        }
    }

//    Soulution
//    //思路：设置一个index，表示非0数的个数，循环遍历数组，
//    // 如果不是0，将非0值移动到第index位置,然后index + 1
//    //遍历结束之后，index值表示为非0的个数，再次遍历，从index位置后的位置此时都应该为0
//    public void moveZeroes(int[] nums) {
//        if (nums == null || nums.length <= 1) {
//            return;
//        }
//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[index] = nums[i];
//                index++;
//            }
//        }
//
//        for (int i = index; i < nums.length; i++) {
//            nums[i] = 0;
//        }
//    }



    public static void main(String[] args) {
        int[] t1 = {0,1,0,3,12};

        LC283_Move_Zeroes a = new LC283_Move_Zeroes();
        a.moveZeroes(t1);
    }
}
