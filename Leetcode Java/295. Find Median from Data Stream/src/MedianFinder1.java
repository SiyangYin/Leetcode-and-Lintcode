import java.util.PriorityQueue;

public class MedianFinder1 {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder1() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);;
    }

    public void addNum(int num) {
        if (minHeap.isEmpty() || num >= minHeap.peek()) {
            minHeap.offer(num);
        }
        else {
            maxHeap.offer(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
        else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
