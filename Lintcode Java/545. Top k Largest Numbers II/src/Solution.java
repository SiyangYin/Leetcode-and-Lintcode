import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    
    private PriorityQueue<Integer> minHeap;
    private int k;
    
    /*
     * @param k: An integer
     */
    public Solution(int k) {
        // do intialization if necessary
       minHeap = new PriorityQueue<>(k);
       this.k = k;
    }
    
    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if (minHeap.size() < k) {
            minHeap.offer(num);
        } else {
            if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
    }
    
    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> res = new ArrayList<>(minHeap);
        res.sort((i1, i2) -> i1 > i2 ? -1 : 1);
        return res;
    }
}
