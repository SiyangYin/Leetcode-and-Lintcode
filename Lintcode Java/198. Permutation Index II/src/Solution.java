import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndexII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
    
        long res = 0, fact = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) {
                    set.add(A[j]);
                }
            }
        
            res += fact * set.size();
            fact *= A.length - i;
        }
    
        return res + 1;
        
    }
}
