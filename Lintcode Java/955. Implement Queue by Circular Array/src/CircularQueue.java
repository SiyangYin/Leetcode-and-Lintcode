public class CircularQueue {
    
    int[] arr;
    int size;
    int front, end;
    
    public CircularQueue(int n) {
        // initialize your data structure here
        arr = new int[n];
    }
    /**
     * @return:  return true if the array is full
     */
    public boolean isFull() {
        // write your code here
        return size == arr.length;
    }
    
    /**
     * @return: return true if there is no element in the array
     */
    public boolean isEmpty() {
        // write your code here
        return size == 0;
    }
    
    /**
     * @param element: the element given to be added
     * @return: nothing
     */
    public void enqueue(int element) {
        // write your code here
        arr[end] = element;
        end = (end + 1) % arr.length;
        size++;
    }
    
    /**
     * @return: pop an element from the queue
     */
    public int dequeue() {
        // write your code here
        int res = arr[front];
        front = (front + 1) % arr.length;
        size--;
        return res;
    }
}