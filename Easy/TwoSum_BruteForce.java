//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//        You may assume that each input would have exactly one solution, and you may not use the same element twice.
//        You can return the answer in any order.
//        Example 1:
//        Input: nums = [2,7,11,15], target = 9
//        Output: [0,1]
//        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//        Example 2:
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]
//        Example 3:
//        Input: nums = [3,3], target = 6
//        Output: [0,1]
//        Constraints:
//        2 <= nums.length <= 104
//        -109 <= nums[i] <= 109
//        -109 <= target <= 109
//        Only one valid answer exists.

//        Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?


import javax.swing.table.TableCellEditor;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_BruteForce {
    public int[] twoSum(int nums[], int target){
        int[] result =  new int[2];
        for (int i = 0; i < nums.length-1; i++){
            for ( int j = i+1 ; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum_BruteForce twoSumBruteForce = new TwoSum_BruteForce();
        int[] test1 = new int[]{2,7,11,15};
        int[] result1 = twoSumBruteForce.twoSum(test1, 9);
        for(int index : result1){
            System.out.print(index+" ");
        }
        System.out.println();

        int[] test2 = new int[]{3,2,4};
        int[] result2 = twoSumBruteForce.twoSum(test2, 6);
        for(int index : result2){
            System.out.print(index+" ");
        }
        System.out.println();

        int[] test3 = new int[]{3,3};
        int[] result3 = twoSumBruteForce.twoSum(test3, 6);
        for(int index : result2){
            System.out.print(index+" ");
        }
        System.out.println();

    }

//    Official Hash Table
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
//        for (int i = 0; i < nums.length; ++i) {
//            if (hashtable.containsKey(target - nums[i])) {
//                return new int[]{hashtable.get(target - nums[i]), i};
//            }
//            hashtable.put(nums[i], i);
//        }
//        return new int[0];
//    }

}
