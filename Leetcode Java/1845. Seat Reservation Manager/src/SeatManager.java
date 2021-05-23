import java.util.PriorityQueue;

public class SeatManager {
    
    private PriorityQueue<Integer> minHeap;
    
    public SeatManager(int n) {
        minHeap = new PriorityQueue<>();
        while (n-- > 0) {
            minHeap.offer(n + 1);
        }
    }
    
    public int reserve() {
        return minHeap.poll();
    }
    
    public void unreserve(int seatNumber) {
        minHeap.offer(seatNumber);
    }
}