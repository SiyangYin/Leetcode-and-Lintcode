import java.util.ArrayDeque;
import java.util.Deque;

class FrontMiddleBackQueue {
    
    private Deque<Integer> fDeq, rDeq;
    private int size;
    
    public FrontMiddleBackQueue() {
        fDeq = new ArrayDeque<>();
        rDeq = new ArrayDeque<>();
    }
    
    public void pushFront(int val) {
        fDeq.offerFirst(val);
        adjust();
        size++;
    }
    
    public void pushMiddle(int val) {
        fDeq.offerLast(val);
        adjust();
        size++;
    }
    
    public void pushBack(int val) {
        rDeq.offerLast(val);
        adjust();
        size++;
    }
    
    public int popFront() {
        if (size == 0) {
            return -1;
        }
        
        int res = !fDeq.isEmpty() ? fDeq.pollFirst() : rDeq.pollFirst();
        adjust();
        size--;
        return res;
    }
    
    public int popMiddle() {
        if (size == 0) {
            return -1;
        }
        
        int res = fDeq.size() == rDeq.size() ? fDeq.pollLast() : rDeq.pollFirst();
        adjust();
        size--;
        return res;
    }
    
    public int popBack() {
        if (size == 0) {
            return -1;
        }
        
        int res = rDeq.pollLast();
        adjust();
        size--;
        return res;
    }
    
    private void adjust() {
        if (rDeq.size() - fDeq.size() >= 2) {
            fDeq.offerLast(rDeq.pollFirst());
        }
        if (rDeq.size() < fDeq.size()) {
            rDeq.offerFirst(fDeq.pollLast());
        }
    }
    
    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);
        q.pushBack(2);
        q.pushMiddle(3);
        q.pushMiddle(4);
    
        System.out.println(q);
        System.out.println(q.popFront());
        System.out.println(q);
        System.out.println(q.popMiddle());
        System.out.println(q);
        System.out.println(q.popMiddle());
        System.out.println(q);
        System.out.println(q.popBack());
        System.out.println(q.popFront());
        
    }
    
    @Override
    public String toString() {
        return "FrontMiddleBackQueue{" +
                "fDeq=" + fDeq +
                ", rDeq=" + rDeq +
                '}';
    }
}