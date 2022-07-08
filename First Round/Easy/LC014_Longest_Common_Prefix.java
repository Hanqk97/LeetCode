package Easy;
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */

public class LC014_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        int smallStr = Integer.MAX_VALUE;
        for(String a : strs){
            if(a.length()<smallStr){
                smallStr = a.length();
            }
        }

        StringBuilder prefix =  new StringBuilder(smallStr);
        boolean stop = false;
        for(int i=0; i<smallStr;i++){
            char cur = strs[0].charAt(i);
            for(int j=1; j<strs.length;j++){
                if(strs[j].charAt(i)!=cur){
                    stop = true;
                }
            }
            if(stop){
                break;
            }else{
                prefix.append(cur);
            }
        }

        return prefix.toString();
    }
    //时间复杂度：O(mn)O(mn)，其中 mm 是字符串数组中的字符串的平均长度，nn 是字符串的数量。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
    //空间复杂度：O(1)O(1)。使用的额外空间复杂度为常数。

    /*
    Official Solution 01 纵向扫描
     public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
     */

    public static void main(String[] args) {
        String[] t1 = {"flower","flow","flight"};
        LC014_Longest_Common_Prefix a = new LC014_Longest_Common_Prefix();
        System.out.println(a.longestCommonPrefix(t1));
    }
}
