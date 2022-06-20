package Medium;
/*
Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
In one move, you can increment n - 1 elements of the array by 1.
Example 1:
Input: nums = [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
Example 2:
Input: nums = [1,1,1]
Output: 0
Constraints:
n == nums.length
1 <= nums.length <= 105
-109 <= nums[i] <= 109
The answer is guaranteed to fit in a 32-bit integer.
 */

public class LC453UR_Minimum_Moves_to_Equal_Array_Elements {
    // fail pass time exceed
//    public int minMoves(int[] nums) {
//        Arrays.sort(nums);
//        int len = nums.length;
//        int incrementNum = len-1;
//        int moveTimes = 0;
//        while(!checkEqual(nums)){
//            int difference = 0;
//            for(int i=len-2;i>=0;i--){
//                if(nums[i]!=nums[len-1]){
//                    difference = nums[len-1]-nums[i];
//                    break;
//                }
//            }
//            for(int i=0; i<incrementNum;i++){
//                nums[i]+=difference;
//            }
//            moveTimes+=difference;
//            Arrays.sort(nums);
//        }
//        return moveTimes;
//    }
//
//    private boolean checkEqual(int[] nums){
//        int first = nums[0];
//        int last = nums[nums.length-1];
//        boolean statue = false;
//        if((last - first) == 0) statue = true;
//        return statue;
//    }
    //official
    /*
假设你可以无误执行完整个流程，这样可以搭建流程执行前后的桥梁。
将操作流程前后的量进行分析，找到一个不变量，构成等式，进行求解。
根据题意，每次操作将会使 n - 1 个元素增加 1 。由于你执行了 k 次，所以一共会使 sum 增加 k * (n - 1) 。即操作结束后数组的和为 sum + k * (n - 1) 。
贪心部分：在整个流程的每次操作中，最小的那个值都会增加 1 。（贪心的证明在下个板块，建议最后看）
由贪心可知，经过k 步后， min 变为了 min + k ，也意味着此时数组的每一项都变为了 min + k ，所以操作结束后数组的和为 n * (min + k) 。
根据等量代换：
sum + k * (n - 1) = n * (min + k)
sum + k * n - k = n * min + n * k
sum - k = n * min
k = sum - n * min
所以，最短操作次数为 k = sum - n * min 。
先求和再减去长度n个最小值，不是相当于每一项减去最小值再求和吗？
     */
    public int minMoves(int[] nums) {
        int l = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        return sum - l * min;
    }

    public static void main(String[] args) {
        int[] t1 = {1,2,3};
        LC453UR_Minimum_Moves_to_Equal_Array_Elements a = new LC453UR_Minimum_Moves_to_Equal_Array_Elements();
        System.out.println("\n"+"Result:"+a.minMoves(t1));
    }
}
