import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param A: An integer array
     * @param queries: The query list
     * @return: The number of element in the array that are smaller that the given integer
     */
    public List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            res.add(0);
        }
        
        if (A == null || A.length == 0) {
            return res;
        }
    
        Arrays.sort(A);
        for (int i = 0; i < queries.length; i++) {
            res.set(i, binarySearch(A, queries[i]));
        }
        
        return res;
    }
    
    private int binarySearch(int[] A, int k) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (A[m] >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return A[l] >= k ? l : A.length;
    }
}
