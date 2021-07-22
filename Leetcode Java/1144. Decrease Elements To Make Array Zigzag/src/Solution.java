import java.util.Arrays;

public class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int[] A = Arrays.copyOf(nums, nums.length);
        int v1 = 0, v2 = 0;
        
        for (int i = 0; i < A.length; i += 2) {
            int diff = 0;
            if (i - 1 >= 0 && A[i] >= A[i - 1]) {
                diff = Math.max(diff, A[i] - A[i - 1] + 1);
            }
            if (i + 1 < A.length && A[i] >= A[i + 1]) {
                diff = Math.max(diff, A[i] - A[i + 1] + 1);
            }
            A[i] -= diff;
            v1 += diff;
        }
        
        A = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < A.length; i += 2) {
            int diff = 0;
            if (i - 1 >= 0 && A[i] >= A[i - 1]) {
                diff = Math.max(diff, A[i] - A[i - 1] + 1);
            }
            if (i + 1 < A.length && A[i] >= A[i + 1]) {
                diff = Math.max(diff, A[i] - A[i + 1] + 1);
            }
            A[i] -= diff;
            v2 += diff;
        }
        
        return Math.min(v1, v2);
    }
    
    public static void main(String[] args) {
        int[] A = {7, 4, 8, 9, 7, 7, 5};
        System.out.println(new Solution().movesToMakeZigzag(A));
    }
}
