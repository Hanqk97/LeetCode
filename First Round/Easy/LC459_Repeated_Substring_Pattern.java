package Easy;

import javax.xml.stream.FactoryConfigurationError;

//Given a string s, check if it can be constructed
// by taking a substring of it and appending multiple copies of the substring together.
//Example 1:
//Input: s = "abab"
//Output: true
//Explanation: It is the substring "ab" twice.
//Example 2:
//Input: s = "aba"
//Output: false
//Example 3:
//Input: s = "abcabcabcabc"
//Output: true
//Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
public class LC459_Repeated_Substring_Pattern {

    public boolean repeatedSubstringPattern(String s) {
        for(int i = 0; i < s.length(); i++){
            if(s.length()%(i+1) == 0 && i != s.length()-1){
                String[] cur = new String[s.length()/(i+1)];
                cur = this.splitStr(s, i);
                String sub = this.subString(s,i);
                boolean mark = true;
                for(int k = 0; k < cur.length; k++){
                    if(cur[k].compareTo(sub)!=0){
                        mark = false;
                    }
                }
                if(mark) return true;
            }
        }
        return false;

    }


    private String[] splitStr(String s, int count){
        String[] a = new String[s.length()/(count+1)];
        int j = 0;

        for(int i=0;  i < s.length(); i += (count+1)){
            char[] temp = new char[count+1];
            for(int m = 0; m < count+1; m++){
                temp[m] = s.charAt(i+m);
            }
            a[j] = new String(temp);
            j++;
        }
        return a;
    }

    private String subString(String s, int lastIndex){
        char[] base =  new char[lastIndex+1];
        for(int i = 0; i <= lastIndex; i++){
            base[i] = s.charAt(i);
        }
        return new String(base);
    }

    public static void main(String[] args) {
        String t1 = new String("abab");
        LC459_Repeated_Substring_Pattern a = new LC459_Repeated_Substring_Pattern();
//        System.out.println(a.subString(t1,2));
//        String[] sub = a.splitStr(t1,2);
//        System.out.println(a.);
//        for(String b : sub){
//            System.out.println(b);
//        }
        System.out.println(a.repeatedSubstringPattern(t1));


        int d = 4;
        int f = 2;
        System.out.println(d%f);
    }

}
