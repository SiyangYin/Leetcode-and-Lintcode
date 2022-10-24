import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class FrontMiddleBackQueue1 {
    private List<Integer> list;
    public FrontMiddleBackQueue1() {
        list = new LinkedList<>();
    }

    public void pushFront(int val) {
        list.add(0, val);
    }

    public void pushMiddle(int val) {
        list.add(list.size() / 2, val);
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        return list.isEmpty() ? -1 : list.remove(0);
    }

    public int popMiddle() {
        return list.isEmpty() ? -1 : list.remove((list.size() - 1) / 2);
    }

    public int popBack() {
        return list.isEmpty() ? -1 : list.remove(list.size() - 1);
    }
    
    public static void main(String[] args) {
        FrontMiddleBackQueue1 q = new FrontMiddleBackQueue1();
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
                "list=" + list +
                '}';
    }
}