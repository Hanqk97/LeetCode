package Easy;

//https://leetcode.com/problems/reverse-linked-list/
public class LC206_Reverse_Linked_List {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head.next == null){
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next =pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

}
