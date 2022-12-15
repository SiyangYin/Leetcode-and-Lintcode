import java.util.LinkedList;
import java.util.List;

public class MyCircularDeque1 {
    private List<Integer> list;
    private int k;
    public MyCircularDeque1(int k) {
        list = new LinkedList<Integer>();
        this.k = k;
    }

    public boolean insertFront(int value) {
        if (list.size() < k) {
            list.add(0, value);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean insertLast(int value) {
        if (list.size() < k) {
            list.add(value);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteFront() {
        if (!list.isEmpty()) {
            list.remove(0);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean deleteLast() {
        if (!list.isEmpty()) {
            list.remove(list.size() - 1);
            return true;
        }
        else {
            return false;
        }
    }

    public int getFront() {
        if (!list.isEmpty()) {
            return list.get(0);
        }
        else {
            return -1;
        }
    }

    public int getRear() {
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }
        else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == k;
    }
    
    public static void main(String[] args) {
        MyCircularDeque1 dq = new MyCircularDeque1(2);
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
