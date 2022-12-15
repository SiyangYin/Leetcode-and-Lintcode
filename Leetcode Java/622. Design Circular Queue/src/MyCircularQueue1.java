import java.util.LinkedList;
import java.util.List;

public class MyCircularQueue1 {
    private List<Integer> list;
    private int k;
    public MyCircularQueue1(int k) {
        list = new LinkedList<>();
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (list.size() < k) {
            list.add(value);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deQueue() {
        if (!list.isEmpty()) {
            list.remove(0);
            return true;
        }
        else {
            return false;
        }
    }

    public int Front() {
        return list.isEmpty() ? -1 : list.get(0);
    }

    public int Rear() {
        return list.isEmpty() ? -1 : list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == k;
    }
    
    public static void main(String[] args) {
        MyCircularQueue1 queue = new MyCircularQueue1(3);
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
