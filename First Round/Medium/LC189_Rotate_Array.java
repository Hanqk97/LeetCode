package Medium;
/*
Given an array, rotate the array to the right by k steps, where k is non-negative.
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 */

public class LC189_Rotate_Array {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] head = new int[k];
        int[] tail;
        if(k<=len){
            tail = new int[len-k];
        }else{
            tail = new int[len];
            k=k%len;
        }

        for(int i=0,h=0,t=0;i<len;i++){
            if(i<(len-k)){
                tail[t] = nums[i];
                t++;
            }else{
                head[h] = nums[i];
                h++;
            }
        }

        for(int i=0,h=0,t=0;i<len;i++){
            if(i<k){
                nums[i] = head[h];
                h++;
            }else{
                nums[i] = tail[t];
                t++;
            }
        }

    }

//    Official Result
//    public void rotate(int[] nums, int k) {
//        k %= nums.length;
//        reverse(nums, 0, nums.length - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, nums.length - 1);
//    }
//    public void reverse(int[] nums, int start, int end) {
//        while (start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start += 1;
//            end -= 1;
//        }
//    }

    public static void main(String[] args) {
        int[] t1 = {1,2,3,4,5,6,7};
        int[] t2 = {1,2};
        LC189_Rotate_Array a = new LC189_Rotate_Array();
        a.rotate(t1,3);
        a.rotate(t2,3);
        for(int i:t1){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i:t2){
            System.out.print(i+" ");
        }
    }
}
