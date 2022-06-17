package Easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC448_Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> notAppear = new LinkedList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]>1){
                for(int k = 1; k<(nums[i+1]-nums[i]);k++){
                    notAppear.add(nums[i]+k);
                }
            }

            if(i==0&&nums[i]!=1){
                for(int k=0; k<(nums[i]-1);k++){
                    notAppear.add(1+k);
                }
            }

            if((i+1)==nums.length-1 && nums[i+1]!=nums.length){
                for(int k = 1; k<=(nums.length-nums[i+1]);k++){

                    notAppear.add(nums[i+1]+k);
                }
            }
        }

        return notAppear;
    }

//    /**
//     *
//     * 找出 1 - n 中没有出现的数字。不能使用额外的空间，两次循环时间复杂度为 2O(n)，即为 O(n)。
//     *
//     * 解题思路：使用数组的下标来标记数字的出现于否，通过一遍遍历即可标记出全部已经出现的数组
//     *
//     * [4,3,2,7,8,2,3,1] 初始数据
//     *
//     * [4,3,2,-7,8,2,3,1] 第一个数据 4 出现，将数组的第四个也就是下标 3 的数据修改为负数。-7 计算时，通过绝对值处理一下即可不影响数据的计算
//     * [4,3,-2,-7,8,2,3,1]
//     * [4,-3,-2,-7,8,2,3,1]
//     * [4,-3,-2,-7,8,2,-3,1]
//     * [4,-3,-2,-7,8,2,-3,-1]
//     * [4,-3,-2,-7,8,2,-3,-1]
//     * [4,-3,-2,-7,8,2,-3,-1]
//     * [-4,-3,-2,-7,8,2,-3,-1]
//     *
//     * 计算结束，数组的第五个，第六个依然为整数，证明 5,6 没有出现
//     *
//     * @param nums
//     * @return
//     */
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//        List<Integer> results = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[Math.abs(nums[i]) - 1] > 0) {
//                nums[Math.abs(nums[i]) - 1] = - nums[Math.abs(nums[i]) - 1];
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                results.add(i + 1);
//            }
//        }
//        return results;
//    }

    public static void main(String[] args) {
        int[] t1 = {27,40,6,21,14,36,10,19,44,10,41,26,39,20,25,19,14,7,29,27,40,38,11,44,4,6,48,39,9,13,7,45,41,23,31,8,24,1,3,5,28,11,49,29,18,4,38,32,24,15};
        Arrays.sort(t1);
        for(int a:t1){
            System.out.print(a+" ");
        }
        System.out.println();
        int[] t2 = {1,1};

        LC448_Find_All_Numbers_Disappeared_in_an_Array a = new LC448_Find_All_Numbers_Disappeared_in_an_Array();
        for(int i: a.findDisappearedNumbers(t1)){
            System.out.print(i+" ");
        }

        System.out.println();
        for(int i: a.findDisappearedNumbers(t2)){
            System.out.print(i+" ");
        }
    }
}
