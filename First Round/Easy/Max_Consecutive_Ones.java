package Easy;

public class Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int subOnes = 0;

        for(int i=0, j=0; i<nums.length;i++){
            if(nums[i] == 1 ){
                subOnes++;
            }
            if(nums[i] == 0 ){
                if(subOnes >= maxOnes){
                    maxOnes = subOnes;
                    subOnes = 0;
                }else{
                    subOnes = 0;
                }
            }
            if(i == nums.length-1){
                if(subOnes >= maxOnes){
                    maxOnes = subOnes;
                }
            }
        }
        return maxOnes;
    }

//    Official Result
//    public int findMaxConsecutiveOnes(int[] nums) {
//        if (nums.length == 0 || nums == null)
//            return 0;
//        int maxCount = 0, count = 0;
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == 1) {
//                count++;
//            } else {
//                maxCount = Math.max(maxCount, count);
//                count = 0;
//            }
//        }
//        maxCount = Math.max(maxCount, count);
//        return maxCount;
//    }


}
