package Medium;

import java.util.HashMap;

import java.util.Map;

public class LC454UR_4Sum_II {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(0 - temp)) {
                    res += map.get(0 - temp);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {-1, -1}, nums2 = {-1, 1}, nums3 = {-1, 1}, nums4 = {1, -1};
        LC454UR_4Sum_II a = new LC454UR_4Sum_II();
        System.out.println(a.fourSumCount(nums1,nums2,nums3,nums4));
    }
}
