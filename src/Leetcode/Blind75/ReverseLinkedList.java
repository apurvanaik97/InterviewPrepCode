package Leetcode.Blind75;

import static Leetcode.Blind75.DeleteMiddleElementOfLL.printList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        System.out.println("Original List:");
        printList(head);

        head = reverseLinkedList.reverseList(head);

        System.out.println("List after reversing");
        printList(head);
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next; // Store next node
            current.next = prev; // Reverse link
            prev = current; // Move prev forward
            current = next; // Move current forward
        }
        return prev;

    }
}
//ListNode prev = null;
//        ListNode current = head;
//
//        while (current != null) {
//            ListNode next = current.next; // Store next node
//            current.next = prev; // Reverse link
//            prev = current; // Move prev forward
//            current = next; // Move current forward
//        }
//        return prev;