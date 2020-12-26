import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param A: a integer array
     * @param B: a integer array
     * @return: return true or false
     */
    public boolean ArraySummarization(int[] A, int[] B) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }
    
        for (int i = 0; i < B.length; i++) {
            if (isSum(A, B[i])) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean isSum(int[] A, int x) {
        Set<Integer> set = new HashSet<>();
        set.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            if (set.contains(x - A[i])) {
                return true;
            }
            
            set.add(A[i]);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[] A = {9, 6, 12}, B = {1, 2, 3};
        System.out.println(new Solution().ArraySummarization(A, B));
    }
}
