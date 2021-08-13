public class Solution {
    public int smallestCommonElement(int[][] mat) {
        int max = 0;
        for (int[] row : mat) {
            for (int x : row) {
                max = Math.max(max, x);
            }
        }
        
        int[] cnt = new int[max + 1];
        for (int[] row : mat) {
            for (int x : row) {
                cnt[x]++;
            }
        }
    
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] == mat.length) {
                return i;
            }
        }
        
        return -1;
    }
}
