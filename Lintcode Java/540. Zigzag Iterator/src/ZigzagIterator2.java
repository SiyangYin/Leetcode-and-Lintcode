import java.util.Iterator;
import java.util.List;

public class ZigzagIterator2 {
    private Iterator<Integer> it1, it2;
    boolean first;
    
    /*
     * @param v1: A 1d vector
     * @param v2: A 1d vector
     */
    public ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        it1 = v1.iterator();
        it2 = v2.iterator();
        first = true;
    }
    
    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        if (!it1.hasNext()) {
            return it2.next();
        } else if (!it2.hasNext()) {
            return it1.next();
        } else {
            first = !first;
            return !first ? it1.next() : it2.next();
        }
    }
    
    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return it1.hasNext() || it2.hasNext();
    }
}
