/*
* https://leetcode.com/problems/remove-duplicates-from-sorted-list/
* */

public class RemoveDuplicatesFromSortedLinkedList {

    public static void main(String[] args) {
        ListNode listNode = getSortedLinkedListWithDuplicates();
        removeDuplicatesFromSortedLinkedList(listNode);
    }

    private static void removeDuplicatesFromSortedLinkedList(ListNode head) {

        ListNode temp = head;

        while (temp != null && temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;;
            } else {
                temp = temp.next;
            }
        }
    }

    private static ListNode getSortedLinkedListWithDuplicates() {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        return listNode1;
    }

}
