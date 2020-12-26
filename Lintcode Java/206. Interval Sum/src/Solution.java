import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param A: An integer list
     * @param queries: An query list
     * @return: The result list
     */
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        // write your code here
        long[] preSum = new long[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        
        List<Long> res = new ArrayList<>();
        for (Interval query : queries) {
            long end = preSum[query.end + 1], start = preSum[query.start];
            res.add(end - start);
        }
        
        return res;
    }
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}