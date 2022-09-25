package Medium;
//https://leetcode.com/problems/swap-nodes-in-pairs/
public class LC024UR_Swap_Nodes_in_Pairs {
//    class ListNode {
//        int val;
//        Medium.ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, Medium.ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;


        while(pre.next != null && pre.next.next != null){
            ListNode temp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = temp;

            pre = head;
            head = head.next;
        }

        return dummy.next;


    }
}

