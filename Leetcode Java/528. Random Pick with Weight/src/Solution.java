import java.util.Random;

public class Solution {
    
    private int[] preSum;
    private Random random;
    
    public Solution(int[] w) {
        preSum = new int[w.length];
        preSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            preSum[i] = preSum[i - 1] + w[i];
        }
        
        random = new Random();
    }
    
    public int pickIndex() {
        int idx = random.nextInt(preSum[preSum.length - 1]);
        int l = 0, r = preSum.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (preSum[m] > idx) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
}
