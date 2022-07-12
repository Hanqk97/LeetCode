package Easy;
/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
Example 1:
Input: s = "leetcode"
Output: 0
Example 2:
Input: s = "loveleetcode"
Output: 2
Example 3:
Input: s = "aabb"
Output: -1
Constraints:
1 <= s.length <= 105
s consists of only lowercase English letters.
 */

public class LC387_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        int len = s.length();
        int index = -1;

        for(int i=0; i<len; i++){;
            int mark =0;
            for(int j=0; j<len; j++){
                if(s.charAt(i)==s.charAt(j)){
                    mark++;
                }
                if(mark>1){
                    break;
                }
            }
            if(mark==1){
                index = i;
                break;
            }
        }

        return index;
    }
    /*
    Official Solution 01 HashMap
    public int firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    时间复杂度：O(n)，其中 nn 是字符串 s 的长度。我们需要进行两次遍历。
    空间复杂度：O(∣Σ∣)，其中 Σ 是字符集，在本题中 s 只包含小写字母，因此 ∣Σ∣≤26。我们需要 O(∣Σ∣) 的空间存储哈希映射。

    Official Solution 02
    对于哈希映射中的每一个键值对，键表示一个字符，值表示它的首次出现的索引（如果该字符只出现一次）或者 -1（如果该字符出现多次）。当我们第一次遍历字符串时，设当前遍历到的字符为 c，如果 c 不在哈希映射中，我们就将 cc 与它的索引作为一个键值对加入哈希映射中，否则我们将 c 在哈希映射中对应的值修改为 -1。
    在第一次遍历结束后，我们只需要再遍历一次哈希映射中的所有值，找出其中不为 -1 的最小值，即为第一个不重复字符的索引。如果哈希映射中的所有值均为 -1，我们就返回 −1。

    public int firstUniqChar(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        if (first == n) {
            first = -1;
        }
        return first;
    }

    Official Solution 03 Queue
    具体地，我们使用与方法二相同的哈希映射，并且使用一个额外的队列，按照顺序存储每一个字符以及它们第一次出现的位置。当我们对字符串进行遍历时，设当前遍历到的字符为 c，如果 c 不在哈希映射中，我们就将 c 与它的索引作为一个二元组放入队尾，否则我们就需要检查队列中的元素是否都满足「只出现一次」的要求，即我们不断地根据哈希映射中存储的值（是否为 -1）选择弹出队首的元素，直到队首元素「真的」只出现了一次或者队列为空。
    在遍历完成后，如果队列为空，说明没有不重复的字符，返回 -1−1，否则队首的元素即为第一个不重复的字符以及其索引的二元组。

    public int firstUniqChar(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                position.put(ch, -1);
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

    class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }
     */

    public static void main(String[] args) {
        LC387_First_Unique_Character_in_a_String a =new LC387_First_Unique_Character_in_a_String();
        String s = "loveleetcode";
        System.out.println(a.firstUniqChar(s));
    }
}
