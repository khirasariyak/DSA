package LinkedList;

/*
* https://www.geeksforgeeks.org/problems/subtraction-in-linked-list/1
* */

public class SubtractTwoNumbersUsingLinkedList {

    public static void main(String[] args) {
        ListNode first = ListNode.getLinkedList();
        ListNode second = ListNode.getLinkedList();
        System.out.println(subtract(first, second, 0));
    }

    private static ListNode subtract(ListNode first, ListNode second, int borrow) {

        first = reverse(first);
        second = reverse(second);

        ListNode temp1 = first;
        ListNode temp2 = second;

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (temp1 != null || temp2 != null || borrow != 0) {

            int firstV = 0;
            if (temp1 != null) {
                firstV = temp1.val;
                temp1 = temp1.next;
            }

            int secondV = 0;
            if (temp2 != null) {
                secondV = temp2.val;
                temp2 = temp2.next;
            }

            int diff = firstV - secondV - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            ListNode node = new ListNode(diff);
            current.next = node;
            current = node;
        }

        return reverse(dummy.next);
    }

    public static ListNode reverse(ListNode head) {

        ListNode next;
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

}
