package Medium;

/*
You are given an integer array nums of length n.
Assume arrk to be an array obtained by rotating nums by k positions clock-wise. We define the rotation function F on nums as follow:
F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
Return the maximum value of F(0), F(1), ..., F(n-1).
The test cases are generated so that the answer fits in a 32-bit integer.
Example 1:
Input: nums = [4,3,2,6]
Output: 26
Explanation:
F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
Example 2:

Input: nums = [100]
Output: 0
 */
public class LC396UR_Rotate_Function {
    /*
    思路

    记数组 \textit{nums}nums 的元素之和为 \textit{numSum}numSum。根据公式，可以得到：
      F(0) = 0*nums[0]+1*nums[1]+...(n-1)*nums[n-1]
      F(1) = 1*nums[0]+2*nums[1]+...0*nums[i-1]=F(0)+numSum-n*nums[n-1]
   更一般地，当 1 <= k <n 时，F(k) = F(k-1) + numSum - n * nums[n-k]。我们可以不停迭代计算出不同的 F(k)F(k)，并求出最大值。

     */




    public int maxRotateFunction(int[] nums) {
        int f = 0, n = nums.length, numSum = 0;
        for (int i = 0; i < n; i++) {
            f += i * nums[i];
            numSum += nums[i];
        }
        int res = f;
        for (int i = n - 1; i > 0; i--) {
            f += numSum - n * nums[i];
            res = Math.max(res, f);
        }
        return res;
    }

//    复杂度分析
//    时间复杂度：O(n)O(n)，其中 nn 是数组 \textit{nums}nums 的长度。计算 \textit{numSum}numSum 和第一个 ff 消耗 O(n)O(n) 时间，后续迭代 n-1n−1 次 ff 消耗 O(n)O(n) 时间。
//    空间复杂度：O(1)O(1)。仅使用常数空间。


    public static void main(String[] args) {
        int[] t1 = {18, 4, 13, -1, 2, 7, 19, 14, 11, 0, -9, 9, 4, 2, -2, -7, 18, 18, -7, -5, 9, 6, -8, 3, 13, 0, 15, 9, 10, -1, 17, 13, 13, -8, 3, 8, 4, 19, 10, -8, 18, 15, 11, 13, 11, 1, 14, 2, 10, 1, 11, 5, 18, 5, -8, 13, -10, 5, -8, -9, -5, 9, 10, -10, -3, -3, -4, -4, -8, -10};
        int[] t2 = {4, 3, 2, 6};
        LC396UR_Rotate_Function a = new LC396UR_Rotate_Function();
        System.out.println(a.maxRotateFunction(t1));
    }
}
