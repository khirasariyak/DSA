package CustomDataStructure;

import java.util.Arrays;

public class QueueWithArrayDeque {

    private int[] items;
    private int front, rear, count;

    public QueueWithArrayDeque(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (front == rear)
            throw new IllegalStateException();

        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    public int peek() {
        if (count == 0)
            throw new IllegalStateException();

        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size(){
        return items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
    
}
