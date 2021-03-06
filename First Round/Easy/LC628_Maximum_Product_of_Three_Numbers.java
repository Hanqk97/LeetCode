package Easy;

import java.util.Arrays;

public class LC628_Maximum_Product_of_Three_Numbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if(nums[0]<0&&nums[1]<0){
            return Math.max(nums[0]*nums[1]*nums[nums.length-1], nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
        }else{
            return nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        }
    }

    public static void main(String[] args) {
        int[] test1 = {-1,-2,-3};
        int[] test2 = {1,7,3,4};
        LC628_Maximum_Product_of_Three_Numbers t = new LC628_Maximum_Product_of_Three_Numbers();
        System.out.println(t.maximumProduct(test1));
        System.out.println(t.maximumProduct(test2));

    }

//    Offical Linear Scanning
//    public int maximumProduct(int[] nums) {
//        // 最小的和第二小的
//        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
//        // 最大的、第二大的和第三大的
//        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
//
//        for (int x : nums) {
//            if (x < min1) {
//                min2 = min1;
//                min1 = x;
//            } else if (x < min2) {
//                min2 = x;
//            }
//
//            if (x > max1) {
//                max3 = max2;
//                max2 = max1;
//                max1 = x;
//            } else if (x > max2) {
//                max3 = max2;
//                max2 = x;
//            } else if (x > max3) {
//                max3 = x;
//            }
//        }
//
//        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
//    }

}
