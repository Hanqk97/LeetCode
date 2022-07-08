package Easy;
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
public class LC125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int len = s.length();
        s = s.toLowerCase();

        int letterNum = 0;
        for(int i=0; i<len;i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                letterNum++;
            }
        }

        char[] newString =  new char[letterNum];
        for(int i=0,j=0; i<len;i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                newString[j]= s.charAt(i);
                j++;
            }
        }

        if(letterNum%2==0){
            for(int i=0, j=letterNum-1; i<j;i++,j--){
                if(newString[i]!=newString[j]) return false;
            }
        }else{
            for(int i=0, j=letterNum-1; i!=j; i++,j--){
                if(newString[i]!=newString[j]) return false;
            }
        }

        return true;
    }
    /*
    Official Solution 01
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }

    时间复杂度：O(∣s∣)，其中 ∣s∣ 是字符串 s 的长度。

    空间复杂度：O(∣s∣)。由于我们需要将所有的字母和数字字符存放在另一个字符串中，在最坏情况下，新的字符串 sgood 与原字符串 s 完全相同，因此需要使用 O(∣s∣) 的空间。

     */
    /*
    Official Solution 02 原字符串双指针
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

     */


    public static void main(String[] args) {
        String s  = "0P";
        LC125_Valid_Palindrome a = new LC125_Valid_Palindrome();
        System.out.println(a.isPalindrome(s));
    }
}
