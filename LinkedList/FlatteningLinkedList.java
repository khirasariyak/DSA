package LinkedList;

/*
* https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
* */

public class FlatteningLinkedList {

    static class Node {
        int data;
        Node next;
        Node bottom;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }

    public Node flatten(Node root) {
        // code here

        if (root == null || root.next == null) {
            return root;
        }

        Node next = flatten(root.next);
        return merge(root, next);
    }

    private Node merge(Node first, Node second) {
        Node temp1 = first;
        Node temp2 = second;
        Node dummy = new Node(-1);
        Node current = dummy;

        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                current.bottom = temp1;
                temp1 = temp1.bottom;
            } else {
                current.bottom = temp2;
                temp2 = temp2.bottom;
            }
            current = current.bottom;
        }

        while (temp1 != null) {
            current.bottom = temp1;
            temp1 = temp1.bottom;
            current = current.bottom;
        }

        while (temp2 != null) {
            current.bottom = temp2;
            temp2 = temp2.bottom;
            current = current.bottom;
        }

        return dummy.bottom;
    }

}
