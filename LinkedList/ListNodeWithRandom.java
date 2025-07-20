package LinkedList;

public class ListNodeWithRandom {

    int val;
    ListNodeWithRandom next;
    ListNodeWithRandom random;

    public ListNodeWithRandom(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNodeWithRandom{" +
                "val=" + val +
                ", next=" + next +
                ", random=" + random +
                '}';
    }


    public static ListNodeWithRandom getLinkedList() {

        ListNodeWithRandom node1 = new ListNodeWithRandom(1);
        ListNodeWithRandom node2 = new ListNodeWithRandom(2);
        ListNodeWithRandom node3 = new ListNodeWithRandom(3);
        ListNodeWithRandom node4 = new ListNodeWithRandom(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        node1.random = node3;
        node4.random = node1;
        node3.random = null;
        node2.random = node1;

        return node1;
    }

}
