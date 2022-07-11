package Easy;
/*
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:
Input: s = "God Ding"
Output: "doG gniD"
Constraints:
1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
 */

public class LC557_Reverse_Words_in_a_String_III {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        int len = s.length();

        for(int i=1, prev = 0, cur = 0; i<len; i++){
            if(str[i]==' '){
                cur = i-1;
                reverse(str,prev,cur);
                prev = i+1;
            }

            if(i==len-1){
                cur = i;
                reverse(str,prev,cur);
            }
        }

        s = new String(str);
        return s;

    }

    private void reverse(char[] str, int left, int right){
        while(left<right){
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }
    /*
    时间复杂度：O(N)。字符串中的每个字符要么在 O(1) 的时间内被交换到相应的位置，要么因为是空格而保持不动。
    空间复杂度：O(N)。我们开辟了与原字符串等大的空间。
     */
    public static void main(String[] args) {
        LC557_Reverse_Words_in_a_String_III a = new LC557_Reverse_Words_in_a_String_III();
        String s = "vector<string> split (string s, char delimiter)";//">gnirts<rotcev tilps gnirts( ,s rahc )retimiled"
        System.out.println(a.reverseWords(s));
    }
}
