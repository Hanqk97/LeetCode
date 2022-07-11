package Easy;
/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
Constraints:
1 <= s.length <= 105
s[i] is a printable ascii character.
 */

public class LC344_Reverse_String {
    public void reverseString(char[] s) {
        int len = s.length;
        int left = 0;
        int right = len-1;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
    /*
    时间复杂度：O(N)，其中 NN 为字符数组的长度。一共执行了 N/2 次的交换。
    空间复杂度：O(1)。只使用了常数空间来存放若干变量。
     */
    public static void main(String[] args) {
        LC344_Reverse_String a = new LC344_Reverse_String();
        char[] t1 = {'H','a','n','n','a','h'};
        a.reverseString(t1);
        for(char c: t1){
            System.out.println(c);
        }
    }
}
