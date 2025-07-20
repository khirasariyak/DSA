package LinkedList;

/*
* https://leetcode.com/problems/middle-of-the-linked-list/
* */

public class MiddleElementOfLinkedList {

    public static void main(String[] args) {
        ListNode head = ListNode.getLinkedList();
        System.out.println(middleElementOfLinkedList(head));
    }

    private static ListNode middleElementOfLinkedList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

}
