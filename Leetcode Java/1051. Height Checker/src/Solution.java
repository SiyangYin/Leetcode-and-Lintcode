public class Solution {
    public int heightChecker(int[] heights) {
        int[] hcnt = new int[101];
        for (int height : heights) {
            hcnt[height]++;
        }
        
        int res = 0;
        for (int i = 0, idx = 0; i < heights.length; i++) {
            while (hcnt[idx] == 0) {
                idx++;
            }
            
            if (idx != heights[i]) {
                res++;
            }
            
            hcnt[idx]--;
        }
        
        return res;
    }
}
