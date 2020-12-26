import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {
    
    private Iterator<List<Integer>> it;
    private Iterator<Integer> it1;
    
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        it = vec2d.iterator();
    }
    
    @Override
    public Integer next() {
        // Write your code here
        return it1.next();
    }
    
    @Override
    public boolean hasNext() {
        // Write your code here
        if (it1 != null && it1.hasNext()) {
            return true;
        }
    
        List<Integer> next = null;
        while (it.hasNext()) {
            next = it.next();
            if (!next.isEmpty()) {
                break;
            }
        }
    
        if (next == null || next.isEmpty()) {
            return false;
        }
        
        it1 = next.iterator();
        return true;
    }
    
    @Override
    public void remove() {
        it1.remove();
    }
    
    public static void main(String[] args) {
        List<List<Integer>> vec = new ArrayList<>();
        List<Integer> v1 = new ArrayList<>();
        v1.add(1);
        v1.add(2);
        
        List<Integer> v2 = new ArrayList<>();
        v2.add(3);
        
        List<Integer> v3 = new ArrayList<>();
        v3.add(4);
        v3.add(5);
        v3.add(6);
        
        vec.add(v1);
        vec.add(v2);
        vec.add(v3);
    
        Vector2D v = new Vector2D(vec);
        while (v.hasNext()) {
            System.out.println(v.next());
        }
        
    }
}
