package LinkedList;

/*
* https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1
* */

public class SortLinkedListWith012 {

    public static void main(String[] args) {
        ListNode head = getLinkedList();
        System.out.println(sort(head));
    }

    private static ListNode sort(ListNode head) {

        ListNode zeroHead = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);
        ListNode zeroTail = zeroHead;
        ListNode oneTail = oneHead;
        ListNode twoTail = twoHead;

        ListNode temp = head;

        while(temp != null) {
            int val = temp.val;
            if (val == 0) {
                zeroTail.next = temp;
                zeroTail = zeroTail.next;
            } else if (val == 1) {
                oneTail.next = temp;
                oneTail = oneTail.next;
            } else if (val == 2) {
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
            temp = temp.next;
        }

        if (oneHead == oneTail) {
            zeroTail.next = twoHead.next;
        } else {
            zeroTail.next = oneHead.next;
        }

        if (twoHead == twoTail) {
            oneTail.next = null;
        } else {
            oneTail.next = twoHead.next;
        }

        twoTail.next = null;
        return zeroHead.next;
    }

    private static ListNode getLinkedList() {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(0);
        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(2);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;

        return listNode1;
    }

}
