package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC018UR_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        if(nums.length<4) return result;

        for(int i=0; i < nums.length; i++){
            if (nums[i] > 0 && nums[i]>target) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for(int j = i+1; j<nums.length; j++){

                if(j > i+1 && nums[j-1] == nums[j]){
                    continue;
                }

                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target){
                        right --;
                    }else if(sum < target){
                        left ++;
                    }else{
                        result.add(Arrays.asList(nums[i] , nums[j] , nums[left] , nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] t1 = {2,2,2,2,2};
        LC018UR_4Sum a = new LC018UR_4Sum();
        System.out.println(a.fourSum(t1,8));
    }
}
