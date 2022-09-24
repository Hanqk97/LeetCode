package Medium;
//https://leetcode.com/problems/design-linked-list/submissions/
public class LC707_Design_Linked_List {

        int size;
        ListNode head;

        public LC707_Design_Linked_List() {
            size = 0;
            head = new ListNode(0);

        }

        public int get(int index) {
            if(index < 0 || index >= size){
                return -1;
            }
            ListNode cur = head;
            for(int i = 0; i <= index; i++){
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        public void addAtIndex(int index, int val) {
            if(index > size){
                return;
            }

            ListNode newNode = new ListNode(val);
            ListNode cur = head;

            for(int i=0; i<index; i++){
                cur = cur.next;
            }

            newNode.next =cur.next;
            cur.next = newNode;
            size ++;

        }

        public void deleteAtIndex(int index) {
            if(index < 0 || index > (size-1)){
                return;
            }

            ListNode cur = head;
            for(int i = 0; i<index; i++){
                cur = cur.next;
            }

            cur.next = cur.next.next;
            size --;

        }
    }

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val){
            this.val = val;
        }


    public static void main(String[] args) {
        LC707_Design_Linked_List myLinkedList = new LC707_Design_Linked_List();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedList.get(1);              // return 2
        myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
        myLinkedList.get(1);
    }
}
