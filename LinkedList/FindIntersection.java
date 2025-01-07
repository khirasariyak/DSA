/*
* https://www.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1
* */

public class FindIntersection {

    static ListNode intersectPoint(ListNode head1, ListNode head2) {
        // code here

        int l1 = getLength(head1);
        int l2 = getLength(head2);

        ListNode headA = head1;
        ListNode headB = head2;

        while (l1 > l2) {
            headA = headA.next;
            l1--;
        }

        while (l2 > l1) {
            headB = headB.next;
            l2--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    static int getLength(ListNode head) {

        ListNode temp = head;
        int count = 1;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

}
