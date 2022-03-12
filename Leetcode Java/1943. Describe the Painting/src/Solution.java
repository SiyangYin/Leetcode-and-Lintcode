import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        List<List<Long>> res = new ArrayList<>();
        int max = 0;
        for (int[] seg : segments) {
            max = Math.max(max, seg[1]);
        }
        
        long[] diff = new long[max + 1];
        boolean[] mark = new boolean[max + 1];
        for (int[] seg : segments) {
            diff[seg[0]] += seg[2];
            diff[seg[1]] -= seg[2];
            mark[seg[0]] = mark[seg[1]] = true;
        }
        
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        
        for (int i = 1; i < diff.length - 1; i++) {
            if (mark[i] && diff[i] > 0) {
                int j = i + 1;
                while (j < diff.length - 1 && !mark[j]) {
                    j++;
                }
                
                res.add(new ArrayList<>(Arrays.asList((long) i, (long) j, diff[i])));
                i = j - 1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] seg = {{1, 4, 5}, {1, 4, 7}, {4, 7, 1}, {4, 7, 11}};
        System.out.println(new Solution().splitPainting(seg));
    }
}
