package Medium;
/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:
Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

public class LC053UR_Maximum_Subarray {
    /*
    f(i) 代表以第 i 个数结尾的「连续子数组的最大和」
    需要求出每个位置的 f(i)，然后返回 f 数组中的最大值即可。那么我们如何求 f(i) 呢？我们可以考虑 nums[i]
    单独成为一段还是加入 f(i−1) 对应的那一段，这取决于 nums[i] 和 f(i−1)+nums[i] 的大小，
    我们希望获得一个比较大的，于是可以写出这样的动态规划转移方程：

    f(i)=max{f(i−1)+nums[i],nums[i]}

    用一个 f 数组来保存 f(i) 的值，用一个循环求出所有 f(i)。考虑到 f(i) 只和 f(i−1) 相关，于是我们可以只用一个变量
    pre 来维护对于当前 f(i) 的 ff(i−1) 的值是多少，从而让空间复杂度降低到 O(1)，这有点类似「滚动数组」的思想。

    时间复杂度：O(n)，其中 n 为 nums 数组的长度。我们只需要遍历一遍数组即可求得答案。
    空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    /*
    Official Solution 分治法

    定义一个操作 get(a, l, r) 表示查询 a 序列 [l,r] 区间内的最大子段和，那么最终我们要求的答案就是 get(nums, 0, nums.size() - 1)。
    如何分治实现这个操作呢？对于一个区间 [l,r]，我们取 m = (l+r)/2}，
    对区间 [l,m] 和 [m+1,r] 分治求解。当递归逐层深入直到区间长度缩小为 1 的时候，递归「开始回升」。这个时候我们考虑如何通过 [l,m] 区间的信息和 [m+1,r] 区间的信息合并成区间[l,r] 的信息。
    最关键的两个问题是：

    我们要维护区间的哪些信息呢？我们如何合并这些信息呢？对于一个区间 [l,r]，我们可以维护四个量：

    lSum 表示 [l,r][l,r] 内以 l 为左端点的最大子段和
    rSum 表示 [l,r][l,r] 内以 r 为右端点的最大子段和
    mSum 表示 [l,r][l,r] 内的最大子段和
    iSum 表示 [l,r][l,r] 的区间和
    以下简称 [l,m] 为 [l,r] 的「左子区间」，[m+1,r] 为 [l,r] 的「右子区间」。
    我们考虑如何维护这些量呢（如何通过左右子区间的信息合并得到 [l,r] 的信息）？
    对于长度为 1 的区间[i,i]，四个量的值都和 nums[i] 相等。
    对于长度大于 1 的区间：
    首先最好维护的是 iSum，区间 [l,r] 的 iSum 就等于「左子区间」的 iSum 加上「右子区间」的 iSum。
    对于 [l,r] 的 lSum，存在两种可能，它要么等于「左子区间」的 lSum，要么等于「左子区间」的 iSum 加上「右子区间」的 lSum，二者取大。
    对于 [l,r] 的 rSum，同理，它要么等于「右子区间」的 rSum，要么等于「右子区间」的 iSum 加上「左子区间」的 rSum，二者取大。
    当计算好上面的三个量之后，就很好计算 [l,r] 的 mSum 了。我们可以考虑 [l,r] 的 mSum 对应的区间是否跨越 m:
    它可能不跨越 m，也就是说 [l,r] 的 mSum 可能是「左子区间」的 mSum 和 「右子区间」的 mSum 中的一个；
    它也可能跨越 m，可能是「左子区间」的 rSum 和 「右子区间」的 lSum 求和。三者取大。
    这样问题就得到了解决。


    public class Status {
      public int lSum, rSum, mSum, iSum;

      public Status(int lSum, int rSum, int mSum, int iSum) {
           this.lSum = lSum;
           this.rSum = rSum;
           this.mSum = mSum;
           this.iSum = iSum;
       }
   }

    public int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    时间复杂度：假设我们把递归的过程看作是一颗二叉树的先序遍历，那么这颗二叉树的深度的渐进上界为 O(logn)，
    这里的总时间相当于遍历这颗二叉树的所有节点，故总时间的渐进上界是 O(∑(log n, i=1) (2^i-1)) = O(n)，故渐进时间复杂度为 O(n)。
    空间复杂度：递归会使用 (logn) 的栈空间，故渐进空间复杂度为 O(logn)。
     */



    public static void main(String[] args) {
        LC053UR_Maximum_Subarray a = new LC053UR_Maximum_Subarray();
        int[] t1 = {5,4,-1,7,8};
        System.out.println(a.maxSubArray(t1));
    }
}
