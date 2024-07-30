public class StackWithLinkedList {

  private class Node {
    private final int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node top;

  public StackWithLinkedList() {
    this.top = null;
  }

  public void push(int item) {
    var node = new Node(item);

    if (node == null)
      throw new StackOverflowError();

    node.next = top;
    top = node;
  }

  public int pop() {
    if (top == null)
      throw new IllegalStateException();

    var popped = top;
    top = top.next;
    return popped.value;
  }

  public int peek() {
    if (top == null)
      throw new IllegalStateException();

    return top.value;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public void print() {
    if (top == null)
      throw new IllegalStateException();

    var temp = top;
    while (temp != null) {
      System.out.println(temp.value);
      temp = temp.next;
    }
  }
  
}
