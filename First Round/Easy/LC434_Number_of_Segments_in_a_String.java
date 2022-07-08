package Easy;
/*
Given a string s, return the number of segments in the string.
A segment is defined to be a contiguous sequence of non-space characters.
Example 1:
Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]
Example 2:
Input: s = "Hello"
Output: 1
Constraints:
0 <= s.length <= 300
s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
The only space character in s is ' '.
 */

public class LC434_Number_of_Segments_in_a_String {
    public int countSegments(String s) {
        int wordNum = 0;

        if(s.length()==1){
            if(Character.isLetter(s.charAt(0))){
                return 1;
            }else{
                return 0;
            }
        }

        for(int i=1; i<s.length();i++){
            if((s.charAt(i)==' ')&&(s.charAt(i-1)!=' ')){
                wordNum++;
            }
            if((i==s.length()-1)&&(s.charAt(i)!=' ')){
                wordNum++;
            }
        }
        return wordNum;
    }
    /*
    时间复杂度：O(n)，只需要遍历一遍字符串检测每个下标即可。
    空间复杂度：O(1)。
     */
    public static void main(String[] args) {
        String t1 = "a, b, c";
        LC434_Number_of_Segments_in_a_String a = new LC434_Number_of_Segments_in_a_String();
        System.out.println(a.countSegments(t1));
    }
}
