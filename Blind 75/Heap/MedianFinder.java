import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/find-median-from-data-stream/
 */

public class MedianFinder {
    
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        
        if(maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if (minHeap.isEmpty() && maxHeap.isEmpty()) {
            return 0.0;
        }

        if (minHeap.size() == maxHeap.size()) {
            return ( minHeap.peek() + maxHeap.peek() ) / 2.0;
        }
        
        return maxHeap.peek();
    }
}
