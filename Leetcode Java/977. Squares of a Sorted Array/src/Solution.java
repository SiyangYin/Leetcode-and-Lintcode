import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
    
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        
        Arrays.sort(A);
        return A;
    }
    
    public static void main(String[] args) {
        int[] A = {-3, -3, -2, 1};
        System.out.println(Arrays.toString(new Solution().sortedSquares(A)));
    }
}
