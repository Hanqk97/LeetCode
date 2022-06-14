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
}
