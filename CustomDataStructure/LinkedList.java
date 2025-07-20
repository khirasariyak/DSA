package CustomDataStructure;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {

  private static class Node {
    private final int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node first;
  private Node last;
  private int size;

  public void addLast(int item) {
    var node = new Node(item);

    if (isEmpty()) first = last = new Node(item);
    else {
      last.next = node;
      last = node;
    }
    size++;
  }

  public void addFirst(int item) {
    var node = new Node(item);

    if (isEmpty()) first = last = node;
    else {
      node.next = first;
      first = node;
    }
    size++;
  }

  public int indexOf(int item) {
    var current = first;
    int index = 0;

    while (current != null) {
      if (current.value == item) return index;
      current = current.next;
      index++;
    }

    return -1;
  }

  public boolean contains(int item) {
    return indexOf(item) != -1;
  }

  public void removeFirst() {
    if (isEmpty()) throw new NoSuchElementException();

    if (first == last) first = last = null;

    var second = first.next;
    first.next = null;
    first = second;
    size--;
  }

  public void removeLast() {
    if (isEmpty()) throw new NoSuchElementException();

    if (first == last) first = last = null;
    else {
      last = getPreviousNode(last);
      last.next = null;
    }
    size--;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public Node getPreviousNode(Node node) {
    var current = first;

    while (current != null) {
      if (current.next == node) return current;
      current = current.next;
    }
    return null;
  }

  public int[] toArray() {
    var current = first;
    var arr = new int[size];
    int index = 0;

    while (current != null) {
      arr[index++] = current.value;
      current = current.next;
    }
    return arr;
  }

  public void print() {
    System.out.println(Arrays.toString(toArray()));
  }

  public void reverse() {
    var current = first;
    var next = current.next;
  }
  
}
