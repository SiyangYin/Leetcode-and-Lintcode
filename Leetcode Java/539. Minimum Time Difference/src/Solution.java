import java.util.Arrays;
import java.util.List;

public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            String[] split = timePoints.get(i).split(":");
            int t = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            A[i] = t;
        }
    
        Arrays.sort(A);
        int res = A[0] + 24 * 60 - A[n - 1];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, A[i] - A[i - 1]);
        }
        
        return res;
    }
}
