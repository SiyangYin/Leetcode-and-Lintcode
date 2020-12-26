import java.util.Arrays;

public class Solution {
    /**
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        Arrays.sort(envelopes, (e1, e2) -> e1[1] != e2[1] ? Integer.compare(e1[1], e2[1]) : -Integer.compare(e1[0], e2[0]));
        int[] f = new int[envelopes.length];
        int idx = -1;
        for (int i = 0; i < envelopes.length; i++) {
            if (i == 0 || f[idx] < envelopes[i][0]) {
                f[++idx] = envelopes[i][0];
            } else {
                int pos = binarySearch(f, idx, envelopes[i][0]);
                f[pos] = envelopes[i][0];
            }
        }
        
        return idx + 1;
    }
    
    private int binarySearch(int[] f, int idx, int target) {
        int l = 0, r = idx;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (f[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        // int[][] en = {{5,4},{6,4},{6,7},{2,3}};
        int[][] en = {{2, 1}, {4, 1}, {6, 2}, {8, 3}, {10, 5}, {12, 8}, {14, 13}, {16, 21}, {18, 34}, {20, 55}};
        System.out.println(new Solution().maxEnvelopes(en));
    }
}
