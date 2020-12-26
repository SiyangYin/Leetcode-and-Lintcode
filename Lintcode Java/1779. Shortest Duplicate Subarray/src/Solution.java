import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param A: The array you should find shortest subarray length which has duplicate elements.
     * @return: Return the shortest subarray length which has duplicate elements.
     */
    public int getLength(int[] A) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap<>();
        int res = A.length + 1;
    
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                res = Math.min(res, i - map.get(A[i]) + 1);
            }
            
            map.put(A[i], i);
        }
        
        return res <= A.length ? res : -1;
    }
}
