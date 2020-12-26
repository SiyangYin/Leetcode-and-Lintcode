import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        // write your code here
        Set<Long> set = new HashSet<>();
        set.add(1L);
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.offer(1L);
        
        long res = 0;
        int[] list = {2, 3, 5};
        for (int i = 0; i < n; i++) {
            res = minHeap.poll();
            for (int j = 0; j < list.length; j++) {
                if (!set.contains(res * list[j])) {
                    long next = res * list[j];
                    minHeap.offer(next);
                    set.add(next);
                }
            }
        }
        
        return (int) res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(1665));
    }
}
