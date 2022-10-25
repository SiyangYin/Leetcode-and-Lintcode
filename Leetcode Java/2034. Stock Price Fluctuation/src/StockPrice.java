import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StockPrice {
    private Map<Integer, Integer> map;
    private PriorityQueue<int[]> minHeap;
    private PriorityQueue<int[]> maxHeap;
    private int[] current;
    public StockPrice() {
        map = new HashMap<>();
        minHeap = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        maxHeap = new PriorityQueue<>((i1, i2) -> i2[1] - i1[1]);
        current = new int[]{0, 0};
    }

    public void update(int timestamp, int price) {
        map.put(timestamp, price);
        minHeap.offer(new int[]{timestamp, price});
        maxHeap.offer(new int[]{timestamp, price});
        if (timestamp >= current[0]) {
            current[0] = timestamp;
            current[1] = price;
        }
    }

    public int current() {
        return current[1];
    }

    public int maximum() {
        while (maxHeap.peek()[1] != map.get(maxHeap.peek()[0])) {
            int[] i = maxHeap.poll();
            maxHeap.offer(new int[]{i[0], map.get(i[0])});
        }
        return maxHeap.peek()[1];
    }

    public int minimum() {
        while (minHeap.peek()[1] != map.get(minHeap.peek()[0])) {
            int[] i = minHeap.poll();
            minHeap.offer(new int[]{i[0], map.get(i[0])});
        }
        return minHeap.peek()[1];
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
        stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
        System.out.println(stockPrice.current());     // return 5, the latest timestamp is 2 with the price being 5.
        System.out.println(stockPrice.maximum());     // return 10, the maximum price is 10 at timestamp 1.
        stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
        // Timestamps are [1,2] with corresponding prices [3,5].
        System.out.println(stockPrice.maximum());     // return 5, the maximum price is 5 after the correction.
        stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
        System.out.println(stockPrice.minimum());     // return 2, the minimum price is 2 at timestamp 4.
    }
}