package Medium;
//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class LC019_Remove_Nth_Node_From_End_of_List {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode rightNode = head;
        int size = 1;
        while (rightNode.next != null) {
            rightNode = rightNode.next;
            size++;
        }

        ListNode left = dummy;
        for (int i = 0; i < (size - n); i++) {
            left = left.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}
