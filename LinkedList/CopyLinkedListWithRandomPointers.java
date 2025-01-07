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

        Node temp = head;

        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }

        temp = head;
        while (temp != null && temp.next != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        Node curr = head;
        Node newHead = head.next;
        Node newCurr = newHead;

        while (curr != null) {
            curr.next = newCurr.next;
            curr = curr.next;

            if (curr != null) {
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
        }

        return newHead;
    }

}
