import java.util.PriorityQueue;

public class Solution {
    
    class Tuple {
        int val, prime, idx;
        
        public Tuple(int val, int prime, int idx) {
            this.val = val;
            this.prime = prime;
            this.idx = idx;
        }
    }
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        
        int[] nums = new int[n];
        nums[0] = 1;
        int size = 1;
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.val, p2.val));
        
        for (int prime : primes) {
            minHeap.offer(new Tuple(prime, prime, 1));
        }
        
        while (size < n - 1) {
            Tuple cur = minHeap.poll();
            nums[size++] = cur.val;
            minHeap.offer(new Tuple(nums[cur.idx] * cur.prime, cur.prime, cur.idx + 1));
            while (!minHeap.isEmpty() && minHeap.peek().val == nums[size - 1]) {
                cur = minHeap.poll();
                minHeap.offer(new Tuple(nums[cur.idx] * cur.prime, cur.prime, cur.idx + 1));
            }
        }
        
        return minHeap.peek().val;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
        System.out.println(new Solution().nthSuperUglyNumber(15, new int[]{3, 5, 7, 11, 19, 23, 29, 41, 43, 47}));
    }
}
