package LinkedList;

/*
* https://leetcode.com/problems/linked-list-cycle/description/
* https://leetcode.com/problems/linked-list-cycle-ii/description/
* https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
* */

public class FloydCycleDetection {

    public static void main(String[] args) {
        ListNode head = getCircularLinkedList();
        System.out.println(isCyclePresent(head));
        System.out.println(getStartOfCycle(head));
        removeTheCycle(head);
    }

    private static boolean isCyclePresent(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    private static ListNode getStartOfCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }

        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    private static void removeTheCycle(ListNode head) {

        ListNode startOfCycle = getStartOfCycle(head);

        if (startOfCycle == null) {
            return;
        }

        ListNode temp = startOfCycle.next;

        while (temp.next != startOfCycle) {
            temp = temp.next;
        }

        temp.next = null;
    }

    private static ListNode getCircularLinkedList() {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        return listNode1;
    }

}
