public class Solution2 {
    public int shortestSubarray(int[] A, int K) {
        int[] preSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        
        int[] stack = new int[A.length + 1];
        int res = A.length + 1, top = 0;
        for (int i = 0; i < preSum.length; i++) {
            while (top > 0 && preSum[stack[top - 1]] > preSum[i]) {
                top--;
            }
            
            if (top > 0) {
                int l = 0, r = top - 1;
                while (l < r) {
                    int m = l + (r - l + 1 >> 1);
                    if (preSum[i] - preSum[stack[m]] >= K) {
                        l = m;
                    } else {
                        r = m - 1;
                    }
                }
                
                if (preSum[i] - preSum[stack[l]] >= K) {
                    res = Math.min(res, i - stack[l]);
                }
            } else {
                if (preSum[i] >= K) {
                    res = Math.min(res, i);
                }
            }
            
            stack[top++] = i;
        }
        
        return res == A.length + 1 ? -1 : res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().shortestSubarray(new int[]{-11, -15, 76, 41, -41, 68, 41, 12, 73, -8}, 50));
    }
}
