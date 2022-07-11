package Easy;
/*
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
Example 1:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:
Input: s = "abcd", k = 2
Output: "bacd"
Constraints:
1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104
 */

public class LC541_Reverse_String_II {
    public String reverseStr(String s, int k) {
        int len = s.length();
        int doubleK = k*2;
        StringBuilder str = new StringBuilder(s);

        for(int i=0; i<len;i+=doubleK){
            int cur = len - i;
            if(cur>=doubleK){
                reverse(str,i,i+k-1);
            }else if(cur>=k){
                reverse(str, i, i+k-1);
            }else{
                reverse(str, i, len-1);
            }
        }


        return str.toString();

    }

    private void reverse(StringBuilder str, int left, int right){
        while(left<right){
            char temp = str.charAt(left);
            str.setCharAt(left,str.charAt(right));
            str.setCharAt(right,temp);
            left++;
            right--;
        }
    }
    /*
    Official Solution
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    时间复杂度：O(n)，其中 n 是字符串 s 的长度。

    空间复杂度：O(1) 或 O(n)，取决于使用的语言中字符串类型的性质。如果字符串是可修改的，那么我们可以直接在原字符串上修改，空间复杂度为 O(1)，否则需要使用 O(n) 的空间将字符串临时转换为可以修改的数据结构（例如数组），空间复杂度为 O(n)。


     */

    public static void main(String[] args) {
        LC541_Reverse_String_II a = new LC541_Reverse_String_II();
        String t1 = "abcdefg";

        System.out.println(a.reverseStr(t1,2));
    }


}
