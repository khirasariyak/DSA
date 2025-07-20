package LinkedList;

/*
* https://www.geeksforgeeks.org/problems/sort-a-linked-list/1
* */

public class MergeSortForLinkedList {

    public static void main(String[] args) {
        ListNode head = ListNode.getLinkedList();
        System.out.println(mergeSort(head));
    }

    private static ListNode mergeSort(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode right = mid.next;
        ListNode left = head;
        mid.next = null;

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private static ListNode getMid(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode merge(ListNode first, ListNode second) {
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

}
