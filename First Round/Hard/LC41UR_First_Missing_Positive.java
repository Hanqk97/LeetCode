package Hard;
/*
Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.
Example 1:
Input: nums = [1,2,0]
Output: 3
Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
 */

public class LC41UR_First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        // [3, 4, -1, 1]=>[-1,4,3,1]=>[-1,1,3,4]=>while:[1,-1,3,4]
        for(int i=0;i<nums.length;i++){
            while(nums[i]>=1&&nums[i]<len&&nums[i]!=nums[nums[i]-1]){//使用while保证被换过来的数一直交换到合适的位置,不排除同类的话TS为n^2
                swap(nums,i,nums[i]-1);
            }
        }

        // [1, -1, 3, 4]
        for(int i=0; i<nums.length;++i){
            if(nums[i]!=(i+1)){
                return i+1;
            }
        }
        return len+1;
    }

    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] t1 = {3,4,-1,1};
        int[] t2 = {7,8,9,11,12};
        int[] t3 = {1,3,3};
        int[] t4 = {1,2,3,4,5,6,7,8,9,20};

        LC41UR_First_Missing_Positive a = new LC41UR_First_Missing_Positive();
        System.out.println(a.firstMissingPositive(t3));
    }
}
