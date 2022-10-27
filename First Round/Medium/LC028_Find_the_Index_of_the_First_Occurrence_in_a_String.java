package Medium;
//Given two strings needle and haystack, return the index of the first occurrence of needle
// in haystack, or -1 if needle is not part of haystack.

//Example 1:
//
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
//Example 2:
//
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
public class LC028_Find_the_Index_of_the_First_Occurrence_in_a_String {

        public int strStr(String haystack, String needle) {
            int res = -1;
            char[] haystack_array = haystack.toCharArray();
            char[] needle_array = needle.toCharArray();
            if(haystack_array.length < needle_array.length) return res;

            for(int i = 0; i <= haystack_array.length-needle_array.length; i++){
                if(haystack_array[i] == needle_array[0]){
                    for(int j = 0; j < needle_array.length; j++){
                        if(j == needle_array.length-1 && needle_array[j]== haystack_array[i+j]){
                            res = i;
                        }

                        if(needle_array[j]!=haystack_array[i+j]){
                            break;
                        }
                    }
                }

                if(res != -1) {
                    break;
                }
            }


            return res;
        }


}
