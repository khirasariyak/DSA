/*
* https://leetcode.com/problems/add-two-numbers/description/
* */

public class AddTwoNumbersUsingLinkedList {

    public static void main(String[] args) {
        ListNode first = ListNode.getLinkedList();
        ListNode second = ListNode.getLinkedList();
        System.out.println(add(first, second, 0));
    }

    private static ListNode add(ListNode first, ListNode second, int carry) {

        first = reverse(first);
        second = reverse(second);

        ListNode temp1 = first;
        ListNode temp2 = second;

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (temp1 != null || temp2 != null || carry != 0) {

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

            int sum = firstV + secondV + carry;
            carry = sum / 10;
            int digit = sum % 10;
            current.next = new ListNode(digit);
            current = current.next;
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
