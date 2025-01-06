/*
* https://leetcode.com/problems/merge-two-sorted-lists/description/
* */

public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        ListNode first = getFirstSortedLinkedList();
        ListNode second = getSecondSortedLinkedList();

        ListNode mergedNode = merge(first, second);
    }

    private static ListNode merge(ListNode first, ListNode second) {

        if (first == null) {
            return second;
        }

        if (second == null) {
            return first;
        }

        if (first.val <= second.val) {
            return mergeTwoLinkedList(first, second);
        } else {
            return mergeTwoLinkedList(second, first);
        }
    }

    private static ListNode mergeTwoLinkedList(ListNode first, ListNode second) {
        ListNode temp1 = first;
        ListNode temp2 = second;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                current.next = temp1;
                temp1 = temp1.next;
            } else {
                current.next = temp2;
                temp2 = temp2.next;
            }
            current = current.next;
        }

        while (temp1 != null) {
            current.next = temp1;
            temp1 = temp1.next;
            current = current.next;
        }

        while (temp2 != null) {
            current.next = temp2;
            temp2 = temp2.next;
            current = current.next;
        }

        return dummy.next;
    }

    private static ListNode getSecondSortedLinkedList() {

        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        return listNode1;
    }

    private static ListNode getFirstSortedLinkedList() {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        return listNode1;
    }

}
