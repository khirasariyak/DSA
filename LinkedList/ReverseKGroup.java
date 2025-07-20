package LinkedList;

/*
* https://leetcode.com/problems/reverse-nodes-in-k-group/description/
*/

public class ReverseKGroup {

    // ✅ Version 1: Reverse only if group has exactly k nodes
    public ListNode reverseKGroupStrict(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        while (true) {
            ListNode kthNode = getKthNode(curr, k);
            if (kthNode == null) break;

            ListNode nextGroupStart = kthNode.next;

            // Reverse from curr to kthNode
            reverse(curr, kthNode);

            prevGroupEnd.next = kthNode;
            curr.next = nextGroupStart;

            prevGroupEnd = curr;
            curr = nextGroupStart;
        }

        return dummy.next;
    }

    // ✅ Version 2: Always reverse, even if the final group has < k nodes
    public ListNode reverseKGroupAlways(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode curr = head;

        while (curr != null) {
            ListNode kthNode = getKthNode(curr, k);
            ListNode groupEnd = (kthNode != null) ? kthNode : getTail(curr);
            ListNode nextGroupStart = groupEnd.next;

            reverse(curr, groupEnd);

            prevGroupEnd.next = groupEnd;
            curr.next = nextGroupStart;

            prevGroupEnd = curr;
            curr = nextGroupStart;
        }

        return dummy.next;
    }

    public ListNode reverseKGroupAlways2(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        int count = 0;
        ListNode next = null;
        ListNode prev = null;
        ListNode current = head;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) {
            head.next = reverseKGroupAlways2(next, k);
        }

        return prev;
    }

    // 🔧 Get the k-th node starting from curr (0-based index)
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 1) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // 🔧 Get the last node of a list segment
    private ListNode getTail(ListNode node) {
        while (node != null && node.next != null) {
            node = node.next;
        }
        return node;
    }

    // 🔧 Reverse list segment from start to end (inclusive)
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
