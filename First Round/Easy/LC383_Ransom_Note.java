package Easy;
/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.
Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true
Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

public class LC383_Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> rMap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> mMap = new HashMap<Character,Integer>();

        for(int i=0; i<ransomNote.length();i++){
            rMap.put(ransomNote.charAt(i), rMap.getOrDefault(ransomNote.charAt(i),0)+1);
        }

        for(int i=0; i<magazine.length();i++){
            mMap.put(magazine.charAt(i), mMap.getOrDefault(magazine.charAt(i),0)+1);
        }

        for(Map.Entry<Character,Integer> entry: rMap.entrySet()){
            char key = entry.getKey();
            if(mMap.get(key)==null){
                return false;
            }
            if(entry.getValue()>mMap.get(key)){
                return false;
            }
        }

        return true;
    }

    /*
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    时间复杂度：O(m+n)，其中 mm 是字符串 ransomNote 的长度，n 是字符串magazine 的长度，我们只需要遍历两个字符一次即可。
    空间复杂度：O(∣S∣)，SS 是字符集，这道题中 S 为全部小写英语字母，因此 ∣S∣=26。
     */

    public static void main(String[] args) {
        LC383_Ransom_Note a = new LC383_Ransom_Note();
        System.out.println(a.canConstruct("bg","efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj"));
    }
}
