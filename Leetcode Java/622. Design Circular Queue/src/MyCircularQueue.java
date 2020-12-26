public class MyCircularQueue {
    
    private int[] queue;
    private int front, rear;
    private int size;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        
        queue[rear++] = value;
        if (rear >= queue.length) {
            rear -= queue.length;
        }
        
        size++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        
        front++;
        if (front >= queue.length) {
            front -=queue.length;
        }
        
        size--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        
        if (rear > 0) {
            return queue[rear - 1];
        } else {
            return queue[queue.length - 1];
        }
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == queue.length;
    }
    
    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
    }
}
