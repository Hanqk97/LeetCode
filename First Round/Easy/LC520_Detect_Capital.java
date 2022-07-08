package Easy;
/*
We define the usage of capitals in a word to be right when one of the following cases holds:
All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.
Example 1:
Input: word = "USA"
Output: true
Example 2:
Input: word = "FlaG"
Output: false
Constraints:
1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
 */

//Big letter:65~90, Small:97~122
public class LC520_Detect_Capital {
    public boolean detectCapitalUse(String word) {

        boolean needSmall = false;

        if(word.length()==1) return true;
        for(int i=0; i<word.length();i++){
            int asc_2 = (int)(word.charAt(i));
            if(i==0||i==1){
                if(asc_2>=97&&asc_2<=122){
                    needSmall = true;
                }
            }
            if(i>=1&&needSmall) {
                if (asc_2 < 97 || asc_2 > 122) {
                    return false;
                }
            }else if(i!=0){
                    if (asc_2 < 64 || asc_2 > 90) {
                        return false;

                }
            }
        }

        return true;
    }
    /*
    Official Solution
    public boolean detectCapitalUse(String word) {
        // 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); ++i) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }
    ^为异或运算符，相同返回true


     */

    public static void main(String[] args) {
        LC520_Detect_Capital a = new LC520_Detect_Capital();
        System.out.println(a.detectCapitalUse("ggg"));
    }
}
