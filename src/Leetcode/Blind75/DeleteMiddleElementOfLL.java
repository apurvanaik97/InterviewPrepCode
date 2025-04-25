package Leetcode.Blind75;

public class DeleteMiddleElementOfLL {
    public static void main(String[] args) {
        DeleteMiddleElementOfLL deleteMiddleElementOfLL = new DeleteMiddleElementOfLL();
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(7);
        ListNode listNode5 = new ListNode(1);
        ListNode listNode6 = new ListNode(2);
        ListNode listNode7 = new ListNode(6);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = null;


        System.out.println("Original List:");
        printList(head);

        // Delete the middle node
        head = deleteMiddleElementOfLL.deleteMiddle(head);

        System.out.println("List after deleting the middle node:");
        printList(head);

    }
    public ListNode deleteMiddle(ListNode head) {

        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;

        return head;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
