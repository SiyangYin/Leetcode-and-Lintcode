public class Solution2 {
    /**
     * @param A:     An integer array
     * @param start: An integer
     * @param end:   An integer
     * @return: the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // write your code here
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        
        int res = 0;
        for (int i = 1; i < preSum.length; i++) {
            int left = 0, right = 0;
            int target = preSum[i] - end;
            int l = 0, r = i - 1;
            while (l < r) {
                int m = l + (r - l >> 1);
                if (preSum[m] >= target) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            
            if (preSum[l] < target) {
                continue;
            } else {
                left = l;
            }
            
            l = 0;
            r = i - 1;
            target = preSum[i] - start;
            while (l < r) {
                int m = l + (r - l + 1 >> 1);
                if (preSum[m] <= target) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            
            if (preSum[l] > target) {
                continue;
            } else {
                right = l;
            }
            
            res += right - left + 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().subarraySumII(new int[]{1, 2, 3, 4}, 1, 3));
    }
}
