import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param A: The set A
     * @param B: The set B
     * @return: Return the size of three sets
     */
    public int[] getAnswer(int[] A, int[] B) {
        // Write your code here
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }
        
        int common = 0;
        for (int i = 0; i < B.length; i++) {
            if (set.contains(B[i])) {
                common++;
            }
        }
        
        return new int[]{A.length + B.length - common, common, A.length - common};
    }
}
