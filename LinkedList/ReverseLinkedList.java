/*
* https://leetcode.com/problems/reverse-linked-list/description/
* */

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = ListNode.getLinkedList();
        System.out.println(reverseLinkedList(head));
        System.out.println(reverseLinkedListRecursive(head));
    }

    private static ListNode reverseLinkedList(ListNode head) {

        ListNode next;
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private static ListNode reverseLinkedListRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode smallerHead = reverseLinkedListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return smallerHead;
    }

}
