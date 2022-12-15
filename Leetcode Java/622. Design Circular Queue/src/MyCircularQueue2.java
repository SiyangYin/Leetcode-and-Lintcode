import java.util.LinkedList;
import java.util.List;

public class MyCircularQueue2 {
    private int[] arr;
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    public MyCircularQueue2(int k) {
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (size < arr.length) {
            arr[rear] = value;
            rear = (rear + 1) % arr.length;
            size++;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deQueue() {
        if (size > 0) {
            front = (front + 1) % arr.length ;
            size--;
            return true;
        }
        else {
            return false;
        }
    }

    public int Front() {
        return size == 0 ? -1 : arr[front];
    }

    public int Rear() {
        return size == 0 ? -1 : arr[(rear - 1 + arr.length) % arr.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
    
    public static void main(String[] args) {
        MyCircularQueue2 queue = new MyCircularQueue2(3);
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
