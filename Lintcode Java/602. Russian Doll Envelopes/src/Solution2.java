import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    /**
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        Arrays.sort(envelopes, (e1, e2) -> e1[1] != e2[1] ? Integer.compare(e1[1], e2[1]) : -Integer.compare(e1[0], e2[0]));
        System.out.println(Arrays.deepToString(envelopes));
        // int[] f = new int[envelopes.length];
        List<int[]> f = new ArrayList<>();
        int idx = -1;
        for (int i = 0; i < envelopes.length; i++) {
            // if (i == 0 || f[idx] < envelopes[i][0]) {
            if (i == 0 || f.get(f.size() - 1)[0] < envelopes[i][0]) {
                // f[++idx] = envelopes[i][0];
                f.add(envelopes[i]);
            } else {
                // f[binarySearch(f, idx, envelopes[i][0])] = envelopes[i][0];
                int pos = binarySearch(f, envelopes[i][0]);
                // if (f.get(pos)[1] == envelopes[i][1]) {
                //     continue;
                // }
                
                f.set(pos, envelopes[i]);
            }
        }
    
        // System.out.println(Arrays.toString(f));
        System.out.println(f);
        for (int i = 0; i < f.size(); i++) {
            System.out.println(f.get(i)[0]);
        }
        // return idx + 1;
        return f.size();
    }
    
    private int binarySearch(List<int[]> f, int target) {
        int l = 0, r = f.size() - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (f.get(m)[0] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
    
        return l;
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
        int[][] en = {{5,4},{6,4},{6,7},{2,3}};
        // int[][] en = {{2,1},{4,1},{6,2},{8,3},{10,5},{12,8},{14,13},{16,21},{18,34},{20,55}};
        System.out.println(new Solution2().maxEnvelopes(en));
    }
}
