package Easy;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
Example 1:
Input: s = "anagram", t = "nagaram"
Output: true
Example 2:
Input: s = "rat", t = "car"
Output: false
Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

 */
public class LC242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> sMap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> tMap = new HashMap<Character,Integer>();

        for(int i=0; i<s.length();i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0; i<t.length();i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }

        if(sMap.size()!=tMap.size()){
            return false;
        }

        for(Map.Entry<Character,Integer> entry: sMap.entrySet()){
            char key = entry.getKey();
            int sNum = entry.getValue();
            int tNum = tMap.getOrDefault(key,0);
            if(sNum!=tNum){
                return false;
            }
        }

        return true;
    }

    /*
    Official Solution 01 Sort

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    时间复杂度：O(nlogn)，其中 n 为 s 的长度。排序的时间复杂度为O(nlogn)，比较两个字符串是否相等时间复杂度为 O(n)，因此总体时间复杂度为 O(nlogn+n)=O(nlogn)。
    空间复杂度：O(logn)。排序需要 O(logn) 的空间复杂度。注意，在某些语言（比如 Java & JavaScript）中字符串是不可变的，因此我们需要额外的 O(n) 的空间来拷贝字符串。但是我们忽略这一复杂度分析，因为：
    这依赖于语言的细节；
    这取决于函数的设计方式，例如，可以将函数参数类型更改为 char[]。

    Official Solution 02 Table

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    时间复杂度：O(n)，其中 n 为 s 的长度。
    空间复杂度：O(S)，其中 S 为字符集大小，此处 S=26。

     */
    public static void main(String[] args) {
        LC242_Valid_Anagram a = new LC242_Valid_Anagram();
        System.out.println(a.isAnagram("rat","car"));
    }
}
