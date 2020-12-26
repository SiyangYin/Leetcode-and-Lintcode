import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedBlockingQueue {
    
    private Queue<Integer> queue, buffer;
    private int capacity;
    
    public BoundedBlockingQueue(int capacity) {
        queue = new ArrayDeque<>(capacity);
        buffer = new ArrayDeque<>();
        this.capacity = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
        if (queue.size() == capacity) {
            buffer.offer(element);
            throw new InterruptedException();
        } else {
            queue.offer(element);
        }
    }
    
    public int dequeue() throws InterruptedException {
        if (!queue.isEmpty()) {
            queue.offer(buffer.poll());
            return queue.poll();
        } else {
            throw new InterruptedException();
        }
    }
    
    public int size() {
        return queue.size();
    }
    
    public static void main(String[] args) {
        BoundedBlockingQueue queue = new BoundedBlockingQueue(2);
        try {
            queue.enqueue(1);
            queue.dequeue();
            queue.dequeue();
            queue.enqueue(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
}
