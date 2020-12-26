import java.util.Arrays;

public class Solution {
    public int largestUniqueNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        Arrays.sort(A);
        int i = A.length - 1;
        while (i >= 1) {
            if (A[i] != A[i - 1]) {
                return A[i];
            } else {
                while (i >= 1 && A[i] == A[i - 1]) {
                    i--;
                }
                if (i == 0) {
                    return -1;
                }
                
                i--;
            }
        }
        
        return A[0];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().largestUniqueNumber(new int[]{9, 9, 9, 8}));
    }
}
