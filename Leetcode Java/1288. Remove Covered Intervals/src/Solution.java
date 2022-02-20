import java.util.Arrays;

public class Solution {
    public int removeCoveredIntervals(int[][] A) {
        int res = 0, r = -1;
        Arrays.sort(A, (x, y) -> x[0] != y[0] ? Integer.compare(x[0], y[0]) : -Integer.compare(x[1], y[1]));
        for (int[] a : A) {
            if (a[1] <= r) {
                continue;
            }
            
            res++;
            r = a[1];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] A = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(new Solution().removeCoveredIntervals(A));
    }
}
