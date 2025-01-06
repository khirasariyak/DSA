/*
* https://www.geeksforgeeks.org/problems/remove-duplicates-from-an-unsorted-linked-list/1
* */

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromUnsortedLinkedList {

    public static void main(String[] args) {
        ListNode head = getUnSortedLinkedListWithDuplicates();
        removeDuplicatesFromUnsortedLinkedList(head);
    }

    private static void removeDuplicatesFromUnsortedLinkedList(ListNode head) {

        Set<Integer> set = new HashSet<>();

        ListNode temp = head;
        ListNode prev = null;

        while(temp != null) {
            if(!set.add(temp.val)) {
                prev.next  = temp.next;
            } else {
                prev = temp;
            }
            temp = temp.next;
        }
    }

    private static ListNode getUnSortedLinkedListWithDuplicates() {

        ListNode listNode1 = new ListNode(15);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(20);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        return listNode1;
    }

}
