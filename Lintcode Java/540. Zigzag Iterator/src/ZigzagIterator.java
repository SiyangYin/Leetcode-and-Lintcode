import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {
    List<Integer> v1, v2;
    int index, len1, len2;
    /*
     * @param v1: A 1d vector
     * @param v2: A 1d vector
     */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        this.v1 = v1;
        this.v2 = v2;
        len1 = v1.size();
        len2 = v2.size();
    }
    
    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        int res = 0;
        if (index < 2 * Math.min(len1, len2)) {
            res = index % 2 == 0 ? v1.get(index / 2) : v2.get(index / 2);
        } else {
            int pos = index - Math.min(len1, len2);
            res = pos < len1 ? v1.get(pos) : v2.get(pos);
        }
        index++;
        return res;
    }
    
    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        return index < v1.size() + v2.size();
    }
    
    public static void main(String[] args) {
        List<Integer> v1 = new ArrayList<>(), v2 = new ArrayList<>();
        v1.add(1);
        v1.add(2);
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);
        ZigzagIterator it = new ZigzagIterator(v1, v2);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
