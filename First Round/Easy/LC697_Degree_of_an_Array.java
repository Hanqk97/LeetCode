package Easy;

import java.util.*;

public class LC697_Degree_of_an_Array {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int maxFrequencyNum = 0;
        for(int i=0;i<nums.length;i++) {
            int count = map.get(nums[i]);
            if (count >= maxFrequencyNum) {
                maxFrequencyNum = count;
            }
        }

        Set<Integer> maxFrequencyNums = new HashSet<>();// store the number with same max frequency
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==maxFrequencyNum){
                maxFrequencyNums.add(nums[i]);
            }
        }

        Map<Integer,Integer> firstPositions = new HashMap<Integer,Integer>();//<num,first position>
        for(int i:maxFrequencyNums){
            for(int j=0;j<nums.length;j++){
                if(i==nums[j]){
                    firstPositions.put(i,j);
                    break;//get out from this loop to outside loop(maxFrequencyNums)
                }
            }
        }

        Map<Integer,Integer> lastPositions = new HashMap<Integer,Integer>();//<num,last position>
        for(int i:maxFrequencyNums){
            for(int j=0;j<nums.length;j++){
                if(i==nums[j]){
                    lastPositions.put(i,j);
                }
            }
        }

        int[] lengths = new int[maxFrequencyNums.size()];//store the lengths
        int j = 0;
        for(int i:maxFrequencyNums){
            int length = lastPositions.get(i)-firstPositions.get(i)+1;
            lengths[j] = length;
            j++;
        }
        Arrays.sort(lengths);//sort lengths, get the min in [0]

        return lengths[0];

    }

//    Official Hash table
//    public int findShortestSubArray(int[] nums) {
//        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if (map.containsKey(nums[i])) {
//                map.get(nums[i])[0]++;
//                map.get(nums[i])[2] = i;
//            } else {
//                map.put(nums[i], new int[]{1, i, i});//int[]{count,first,last}
//            }
//        }
//        int maxNum = 0, minLen = 0;
//        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
//            int[] arr = entry.getValue();//one item, update count, length
//            if (maxNum < arr[0]) {
//                maxNum = arr[0];
//                minLen = arr[2] - arr[1] + 1;
//            } else if (maxNum == arr[0]) {//when have two or more numbers with same max count
//                if (minLen > arr[2] - arr[1] + 1) {
//                    minLen = arr[2] - arr[1] + 1;
//                }
//            }
//        }
//        return minLen;
//    }

    public static void main(String[] args) {
        int[] t1 = {1,2,2,3,1,4,2};

        LC697_Degree_of_an_Array a = new LC697_Degree_of_an_Array();
        a.findShortestSubArray(t1);
        System.out.println(a.findShortestSubArray(t1));
    }
}
