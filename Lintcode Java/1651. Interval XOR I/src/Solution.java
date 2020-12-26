import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param A:
     * @param query:
     * @return: nothing
     */
    public List<Integer> intervalXOR(int[] A, List<Interval> query) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        for (Interval interval : query) {
            res.add(A[interval.start] ^ A[interval.start + 1]);
        }
        
        return res;
    }
}

class Interval {
    int start, end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}