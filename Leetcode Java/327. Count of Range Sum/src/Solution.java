import java.util.Arrays;

public class Solution {
    
    int[] tr;
    int len;
    
    int sum(int k) {
        int res = 0;
        for (int i = k; i > 0; i -= Integer.lowestOneBit(i)) {
            res += tr[i];
        }
        
        return res;
    }
    
    void add(int k, int x) {
        for (int i = k; i <= len; i += Integer.lowestOneBit(i)) {
            tr[i] += x;
        }
    }
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        
        long[] A = new long[3 * (n + 1)];
        for (int i = 0; i <= n; i++) {
            A[3 * i] = preSum[i];
            A[3 * i + 1] = preSum[i] - lower;
            A[3 * i + 2] = preSum[i] - upper;
        }
        
        len = unique(A);
        tr = new int[len + 1];
        int res = 0;
        for (long x : preSum) {
            int l = lsh(A, x - upper), r = lsh(A, x - lower);
            res += sum(r) - sum(l - 1);
            add(lsh(A, x), 1);
        }
        
        return res;
    }
    
    int lsh(long[] A, long x) {
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (A[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l + 1;
    }
    
    int unique(long[] A) {
        Arrays.sort(A);
        int idx = 0;
        for (int i = 0; i < A.length; i++) {
            if (idx == 0 || A[i] > A[idx - 1]) {
                A[idx++] = A[i];
            }
        }
        
        return idx;
    }
    
    public static void main(String[] args) {
        int[] A = {0, -3};
        // int[] A = {0};
        System.out.println(new Solution().countRangeSum(A, 3, 5));
    }
}
