import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Set_Mismatch {
    public int[] findErrorNums(int[] nums) {
        int [] result = new int[2];
        Arrays.sort(nums);
        int k = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]==nums[i-1]){
                result[0] = nums[i];
                for(int j =0; j<nums.length;j++,k++){
                    if(j == i && j<nums.length - 1) j++;
                    if(k!=nums[j]){
                        result [1] = k;
                        break;
                    }
                    result [1] = k+1;
                }
            }
        }
        return result;
    }

//    Official01 Sort
//    public int[] findErrorNums(int[] nums) {
//        int[] errorNums = new int[2];
//        int n = nums.length;
//        Arrays.sort(nums);
//        int prev = 0;
//        for (int i = 0; i < n; i++) {
//            int curr = nums[i];
//            if (curr == prev) {//如果前后着相同，则此处重复
//                errorNums[0] = prev;
//            } else if (curr - prev > 1) {//排序后若两者相差大于1，则被覆盖的为前者+1
//                errorNums[1] = prev + 1;
//            }
//            prev = curr;
//        }
//        if (nums[n - 1] != n) {//如果在循环中未发现相差大于1的，则缺少的是最后一位即nums.length
//            errorNums[1] = n;
//        }
//        return errorNums;
//    }

//    Official Hash Table
//    public int[] findErrorNums(int[] nums) {
//        int[] errorNums = new int[2];
//        int n = nums.length;
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();//前者表示数字，后者表示出现次数
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);//getOrDefault(检测值，default值)如果有检测值就返回检测值，没有就返回default值0
//        }
//        for (int i = 1; i <= n; i++) {//=是为了在最后一位被覆盖的情况
//            int count = map.getOrDefault(i, 0);
//            if (count == 2) {
//                errorNums[0] = i;
//            } else if (count == 0) {
//                errorNums[1] = i;
//            }
//        }
//        return errorNums;
//    }


    public static void main(String[] args) {
        int[] test = {1,5,3,2,2,7,6,4,8,9};
        int[] test2 = {3,3,1};
        Set_Mismatch a = new Set_Mismatch();
        System.out.println(a.findErrorNums(test)[0]+"/"+a.findErrorNums(test)[1]);
        System.out.println(a.findErrorNums(test2)[0]+"/"+a.findErrorNums(test2)[1]);
    }
}
