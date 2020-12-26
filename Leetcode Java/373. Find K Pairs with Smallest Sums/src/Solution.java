import java.util.*;

public class Solution {
    
    class Pair {
        int x, y, sum;
        
        public Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y, sum);
        }
    }
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return res;
        }
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.sum, p2.sum));
        Pair start = new Pair(0, 0, nums1[0] + nums2[0]);
        minHeap.offer(start);
        Set<Pair> visited = new HashSet<>();
        visited.add(start);
        int count = 0;
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            res.add(new ArrayList<>(Arrays.asList(nums1[cur.x], nums2[cur.y])));
            count++;
            if (count == k) {
                break;
            }
            
            if (cur.x + 1 < nums1.length) {
                Pair next = new Pair(cur.x + 1, cur.y, nums1[cur.x + 1] + nums2[cur.y]);
                if (!visited.contains(next)) {
                    visited.add(next);
                    minHeap.offer(next);
                }
            }
            
            if (cur.y + 1 < nums2.length) {
                Pair next = new Pair(cur.x, cur.y + 1, nums1[cur.x] + nums2[cur.y + 1]);
                if (!visited.contains(next)) {
                    visited.add(next);
                    minHeap.offer(next);
                }
            }
            
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }
}
