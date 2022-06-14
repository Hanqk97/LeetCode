import java.util.Arrays;
import java.util.TreeSet;

public class Third_Maximum_Number {
    public int thirdMax(int[] nums) {
        int firstMax = -2147483648;// -2^31
        for(int i=0; i<nums.length;i++){
            if(nums[i] > firstMax){
                firstMax = nums[i];
            }
        }

        int secondMax = -2147483648;// -2^31
        for(int i=0; i<nums.length;i++){
            if(nums[i] > secondMax && nums[i] < firstMax){
                secondMax = nums[i];
            }
        }

        int check = -1;
        for(int i=0; i<nums.length;i++){
            if(nums[i]<secondMax) check = 0;
        }
        if (check != 0) return firstMax;

        int thirdMax = -2147483648;// -2^31
        for(int i=0; i<nums.length;i++){
            if(nums[i] > thirdMax && nums[i] < secondMax){
                thirdMax = nums[i];
            }
        }

        return thirdMax;
    }

    public static void main(String[] args) {
        int nums[] = {2,2,3,1};
        Third_Maximum_Number t = new Third_Maximum_Number();
        System.out.println(t.thirdMax(nums));
    }

//    Official 01 Sort
//    public int thirdMax(int[] nums) {
//        Arrays.sort(nums);// order from small to big
//        reverse(nums);// order from big to small
//        for (int i = 1, diff = 1; i < nums.length; ++i) {
//            if (nums[i] != nums[i - 1] && ++diff == 3) { // 此时 nums[i] 就是第三大的数
//                return nums[i];
//            }
//        }
//        return nums[0];
//    }
//
//    public void reverse(int[] nums) {
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            int temp = nums[left];
//            nums[left] = nums[right];
//            nums[right] = temp;
//            left++;
//            right--;
//        }
//    }

//    Official 02 Ordered Set
//    public int thirdMax(int[] nums) {
//        TreeSet<Integer> s = new TreeSet<Integer>();//from small to big
//        for (int num : nums) {
//            s.add(num);
//            if (s.size() > 3) {
//                s.remove(s.first());
//            }
//        }
//        return s.size() == 3 ? s.first() : s.last();
//    }

//    Official 03 One traversal
//    public int thirdMax(int[] nums) {
//        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
//        for (long num : nums) {
//            if (num > a) {
//                c = b;
//                b = a;
//                a = num;
//            } else if (a > num && num > b) {
//                c = b;
//                b = num;
//            } else if (b > num && num > c) {
//                c = num;
//            }
//        }
//        return c == Long.MIN_VALUE ? (int) a : (int) c;
//    }

}
