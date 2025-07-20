package LinkedList;

/*
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * */

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode list = ListNode.getLinkedList();
        System.out.println(isPalindromicLinkedList(list));
    }

    private static boolean isPalindromicLinkedList(ListNode head) {

        ListNode mid = getMid(head);
        ListNode rev = reverse(mid.next);

        mid.next = null;

        while(rev != null) {
            if(head.val != rev.val) {
                return false;
            }
            head = head.next;
            rev = rev.next;
        }

        return true;
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
