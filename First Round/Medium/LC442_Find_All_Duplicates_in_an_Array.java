package Medium;

import java.util.*;

public class LC442_Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num : nums) {//count times
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Integer> numAppearTwice = new HashSet<>();
        for(int num: nums){//remove duplicate number
            if(map.get(num)==2){
                numAppearTwice.add(num);
            }
        }

        List<Integer> result = new LinkedList<Integer>();
        for(int num : numAppearTwice){//get result list
            result.add(num);
        }

        return result;
    }

//    Official Negative Number
//    public List<Integer> findDuplicates(int[] nums) {
//        int n = nums.length;
//        List<Integer> ans = new ArrayList<Integer>();
    /*
    如果 nums[nums[i]−1] 是正数，说明 nums[i] 还没有出现过，我们将 nums[nums[i]−1] 加上负号；
    如果 nums[nums[i]−1] 是负数，说明 nums[i] 已经出现过一次，我们将 nums[i] 放入答案。
     */
//        for (int i = 0; i < n; ++i) {
//            int x = Math.abs(nums[i]);
//            if (nums[x - 1] > 0) {
//                nums[x - 1] = -nums[x - 1];
//            } else {
//                ans.add(x);
//            }
//        }
//        return ans;
//    }



    public static void main(String[] args) {
        int[] t1 = {4,3,2,7,8,2,3,1};
        int[] t2 = {1,1,2};

        LC442_Find_All_Duplicates_in_an_Array a = new LC442_Find_All_Duplicates_in_an_Array();
        List<Integer> r1 = a.findDuplicates(t1);
        for(int i: r1){
            System.out.print(i+"/");
        }

        List<Integer> r2 = a.findDuplicates(t2);
        for(int i: r2){
            System.out.print(i+"/");
        }
    }
}
