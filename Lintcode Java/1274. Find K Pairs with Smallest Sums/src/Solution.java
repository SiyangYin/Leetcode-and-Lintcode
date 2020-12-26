import java.util.*;

public class Solution {
    
    class Pair implements Comparable<Pair> {
        int idx1, idx2, sum;
        
        public Pair(int idx1, int idx2, int sum) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.sum = sum;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return idx1 == pair.idx1 && idx2 == pair.idx2;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(idx1, idx2);
        }
    
        @Override
        public int compareTo(Pair o) {
            if (this.sum != o.sum) {
                return Integer.compare(this.sum, o.sum);
            }
            
            return Integer.compare(this.idx1, o.idx1);
        }
    }
    
    /**
     * @param nums1: List[int]
     * @param nums2: List[int]
     * @param k:     an integer
     * @return: return List[List[int]]
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        Pair start = new Pair(0, 0, nums1[0] + nums2[0]);
        minHeap.offer(start);
        
        Set<Pair> set = new HashSet<>();
        set.add(start);
        
        for (int i = 0; i < k - 1 && !minHeap.isEmpty(); i++) {
            Pair cur = minHeap.poll();
            res.add(Arrays.asList(nums1[cur.idx1], nums2[cur.idx2]));
            
            if (cur.idx1 < nums1.length - 1) {
                Pair next = new Pair(cur.idx1 + 1, cur.idx2, nums1[cur.idx1 + 1] + nums2[cur.idx2]);
                if (!set.contains(next)) {
                    minHeap.offer(next);
                    set.add(next);
                }
            }
            
            if (cur.idx2 < nums2.length - 1) {
                Pair next = new Pair(cur.idx1, cur.idx2 + 1, nums1[cur.idx1] + nums2[cur.idx2 + 1]);
                if (!set.contains(next)) {
                    minHeap.offer(next);
                    set.add(next);
                }
            }
        }
        
        if (!minHeap.isEmpty()) {
            Pair cur = minHeap.peek();
            res.add(Arrays.asList(nums1[cur.idx1], nums2[cur.idx2]));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] n1 = {-10, -4, 0, 0, 6}, n2 = {3, 5, 6, 7, 8, 100};
        System.out.println(new Solution().kSmallestPairs(n1, n2, 10));
    }
}
