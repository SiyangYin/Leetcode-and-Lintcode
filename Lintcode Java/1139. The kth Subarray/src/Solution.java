public class Solution {
    /**
     * @param A: an array
     * @param k: the kth
     * @return: return the kth subarray
     */
    public long thekthSubarray(int[] A, long k) {
        // wrrite your code here
        long[] preSum = new long[A.length + 1];
        long l = Integer.MAX_VALUE, r = 0;
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
            l = Math.min(l, A[i]);
        }
        
        r = preSum[A.length];
        while (l < r) {
            long m = l + (r - l >> 1), count = getSmaller(preSum, m);
            if (count >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private long getSmaller(long[] preSum, long num) {
        long count = 0;
        for (int i = 1, j = 0; i < preSum.length; i++) {
            while (preSum[i] - preSum[j] > num) {
                j++;
            }
            
            count += i - j;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().thekthSubarray(new int[]{2, 3, 1, 4}, 6));
        System.out.println(new Solution().thekthSubarray(new int[]{8, 11, 15, 19, 4, 2, 19, 16, 18, 7}, 47));
    }
}
