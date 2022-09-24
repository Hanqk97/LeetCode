package Easy;
//https://leetcode.com/problems/remove-linked-list-elements/submissions/
public class LC203_Remove_Linked_List_Elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;

        while(cur.next!=null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }

        return header.next;

    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

