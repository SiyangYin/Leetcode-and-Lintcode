import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigzagIterator2 {
    
    private List<Iterator<Integer>> list;
    private int idx;
    
    /*
     * @param vecs: a list of 1d vectors
     */
    public ZigzagIterator2(List<List<Integer>> vecs) {
        // do intialization if necessary
        list = new ArrayList<>();
        for (List<Integer> vec : vecs) {
            list.add(vec.iterator());
        }
    }
    
    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        hasNext();
        int res = list.get(idx).next();
        idx = (idx + 1) % list.size();
        return res;
    }
    
    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        if (list.get(idx).hasNext()) {
            return true;
        }
        
        int tmp = idx;
        idx = (idx + 1) % list.size();
        while (idx != tmp) {
            if (list.get(idx).hasNext()) {
                return true;
            }
            idx = (idx + 1) % list.size();
        }
        
        return false;
    }
}
