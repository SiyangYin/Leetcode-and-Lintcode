public class MyCircularDeque {
    
    private int[] deque;
    private int front, rear, size, k;
    
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        deque = new int[k];
        this.k = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == k) {
            return false;
        }
        
        if (size == 0) {
            deque[front] = value;
        } else {
            front = (front - 1 + k) % k;
            deque[front] = value;
        }
        
        size++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == k) {
            return false;
        }
        
        if (size == 0) {
            deque[rear] = value;
        } else {
            rear = (rear + 1) % k;
            deque[rear] = value;
        }
        
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            size--;
            return true;
        }
        
        front = (front + 1) % k;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            size--;
            return true;
        }
        
        rear = (rear - 1 + k) % k;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == k;
    }
    
    public static void main(String[] args) {
        MyCircularDeque dq = new MyCircularDeque(2);
        System.out.println(dq.insertFront(7));
        System.out.println(dq.deleteLast());
        System.out.println(dq.getFront());
        System.out.println(dq.insertLast(5));
        System.out.println(dq.insertFront(0));
        System.out.println(dq.getFront());
        System.out.println(dq.getRear());
        System.out.println(dq.getFront());
        System.out.println(dq.getRear());
        System.out.println(dq.insertLast(0));
    }
}
