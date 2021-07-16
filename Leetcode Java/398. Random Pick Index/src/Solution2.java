import java.util.Random;

public class Solution2 {
    
    private int[] A;
    private Random random;
    
    public Solution2(int[] nums) {
        A = nums;
        random = new Random();
    }
    
    public int pick(int target) {
        int cnt = 0, idx = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                cnt++;
                if (random.nextInt(cnt) == 0) {
                    idx = i;
                }
            }
        }
        
        return idx;
    }
}
