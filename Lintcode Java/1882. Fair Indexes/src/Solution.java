import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param A: an array of integers
     * @param B: an array of integers
     * @return: return a integer indicating the number of fair indexes.
     */
    public int CountIndexes(List<Integer> A, List<Integer> B) {
        // Write your code here
        long sumA = 0, sumB = 0;
        for (int i = 0; i < A.size(); i++) {
            sumA += A.get(i);
        }
        for (int i = 0; i < B.size(); i++) {
            sumB += B.get(i);
        }
        
        if (sumA != sumB) {
            return 0;
        }
        
        long preA = 0, preB = 0;
        int res = 0;
        for (int i = 0; i < Math.min(A.size(), B.size()) - 1; i++) {
            preA += A.get(i);
            preB += B.get(i);
            if (preA * 2 != sumA || preB * 2 != sumB) {
                continue;
            }
            
            if (preA == preB) {
                res++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().CountIndexes(Arrays.asList(4, -1, 0, 3), Arrays.asList(-2, 5, 0, 3)));
    }
}
