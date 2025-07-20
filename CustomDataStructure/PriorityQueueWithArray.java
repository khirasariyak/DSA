package CustomDataStructure;

import java.util.Arrays;

public class PriorityQueueWithArray {

    private int[] items;
    private int count;

    public PriorityQueueWithArray(int capacity) {
        items = new int[capacity];
    }

    public void add(int item) {
        if (count == items.length)
            throw new IllegalStateException();

        var index = shiftItemsToInsert(item);
        items[index] = item;
        count++;
    }

    public int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    public int remove() {
        if (count == 0)
            throw new IllegalStateException();

        var temp = items[--count];
        items[count] = 0;
        return temp;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
    
}
