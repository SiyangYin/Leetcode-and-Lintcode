import java.util.*;

public class Solution {
    /**
     * @param nums: the given array
     * @param k: the given k
     * @return: the k most frequent elements
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        // Write your code here
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> freq.get(i1) <= freq.get(i2) ? -1 : 1);
        for (int num : freq.keySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else {
                if (freq.get(num) > freq.get(minHeap.peek())) {
                    minHeap.poll();
                    minHeap.offer(num);
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        res.addAll(minHeap);
        return res;
    }
}
