package Medium;

import java.util.HashSet;

//https://leetcode.com/problems/linked-list-cycle-ii/
public class LC142UR_Linked_List_Cycle_II {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(set.add(temp) != false){
            if(temp == null) return null;
            temp = temp.next;

        }
        return temp;
    }
}
