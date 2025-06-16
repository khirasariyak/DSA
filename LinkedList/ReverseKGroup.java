/*
* https://leetcode.com/problems/reverse-nodes-in-k-group/description/
*/

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node initialization
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize pointers
        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        while (true) {
            // Check if there are at least k nodes remaining
            ListNode kthNode = getKthNode(curr, k);
            if (kthNode == null) break;

            // Mark the start and end of the group
            ListNode groupStart = curr;
            ListNode groupEnd = kthNode;
            ListNode nextGroupStart = groupEnd.next;

            // Reverse current k-group
            reverse(groupStart, groupEnd);

            // Connect previous group with the reversed group
            prevGroupEnd.next = groupEnd;
            groupStart.next = nextGroupStart;

            // Move the pointer forward
            prevGroupEnd = groupStart;
            curr = nextGroupStart;
        }

        return dummy.next;
    }

    // Helper to get the k-th node from current
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 1) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // Helper to reverse a segment from start to end (inclusive)
    private void reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        ListNode stop = end.next;

        while (curr != stop) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
