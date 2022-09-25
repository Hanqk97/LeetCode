package Easy;

import java.util.HashMap;
import java.util.HashSet;

public class LC349_Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i<nums1.length; i++){
            if(isExist(nums2,nums1[i])){
                set.add(nums1[i]);
            }
        }

        int[] result = new int[set.size()];
        int j = 0;
        for(int item : set){
            result[j] = item;
            j++;
        }


        return result;
    }

    private static boolean isExist(int[] nums, int cur){
        for(int i=0; i<nums.length; i++){
            if(nums[i]==cur) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] t1 = {4,9,5};
        int[] t2 = {9,4,9,8,4};
        LC349_Intersection_of_Two_Arrays a = new LC349_Intersection_of_Two_Arrays();
        a.intersection(t1,t2);
    }
}
