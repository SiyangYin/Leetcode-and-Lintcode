import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param A: lists A
     * @param B: lists B
     * @return: the index mapping
     */
    public int[] anagramMappings(int[] A, int[] B) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = B.length - 1; i >= 0; i--) {
            map.put(B[i], i);
        }
        
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = map.get(A[i]);
        }
        
        return res;
    }
}
