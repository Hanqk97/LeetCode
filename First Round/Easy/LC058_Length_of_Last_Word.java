package Easy;
/*
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.
Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
Constraints:
1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.
 */

public class LC058_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int len = s.length();

        boolean start = false;
        int lastNum = 0;
        for(int i=len-1; i>=0; i--){
            if(Character.isLetter(s.charAt(i))){
                start = true;
                lastNum ++;
            }
            if(start&&!Character.isLetter(s.charAt(i))){
                break;
            }
        }

        return lastNum;
    }
    /*
    时间复杂度：O(n)，其中 nn 是字符串的长度。最多需要反向遍历字符串一次。
    空间复杂度：O(1)。
     */
    public static void main(String[] args) {
        LC058_Length_of_Last_Word a = new LC058_Length_of_Last_Word();
        String t1 = "l";
        System.out.println(a.lengthOfLastWord(t1));
    }
}
