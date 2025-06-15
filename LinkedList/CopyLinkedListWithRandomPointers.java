/*
* https://leetcode.com/problems/copy-list-with-random-pointer/
* */

public class CopyLinkedListWithRandomPointers {

    public static void main(String[] args) {
        Node head = Node.getLinkedList();
        System.out.println(copy(head));
    }

    private static Node copy(Node head) {

        if (head == null) {
            return null;
        }

        // Step-1: Place the new copied node in-between the nodes
        Node curr = head;
        while (curr != null) {
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;
            curr = curr.next.next;
        }

        // Step-2: Update the random pointers
        curr = head;
        while(curr != null) {
            Node temp = curr.next;

            if (curr.random == null) {
                temp.random = null;
            } else {
                temp.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        // Step-3: Update the next pointers
        curr = head;
        Node dummy = new Node(-1);
        Node temp = dummy;

        while (curr != null) {
            temp.next = curr.next;
            temp = temp.next;

            curr.next = curr.next.next;
            curr = curr.next;
        }

        return dummy.next;
    }

}
