import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {
    
    private List<Iterator<Integer>> list;
    private int idx;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2, List<Integer> v3) {
        list = new ArrayList<>();
        list.add(v1.iterator());
        list.add(v2.iterator());
        list.add(v3.iterator());
    }
    
    public int next() {
        hasNext();
        int next = list.get(idx).next();
        idx = (idx + 1) % list.size();
        return next;
    }
    
    public boolean hasNext() {
        if (list.get(idx).hasNext()){
            return true;
        }
        
        int tmp = idx;
        idx = (idx + 1) % list.size();
        while (idx != tmp) {
            if (list.get(idx % list.size()).hasNext()) {
                return true;
            }
            idx = (idx + 1) % list.size();
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
        }};
        List<Integer> list2 = new ArrayList<>(){{
            add(4);
            add(5);
            add(6);
            add(7);
        }};
        List<Integer> list3 = new ArrayList<>(){{
            add(8);
            add(9);
        }};
        
        ZigzagIterator it = new ZigzagIterator(list1, list2, list3);
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
