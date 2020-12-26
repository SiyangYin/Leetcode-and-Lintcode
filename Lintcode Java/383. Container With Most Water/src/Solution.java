public class Solution {
    /**
     * @param heights: a vector of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int res = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(heights[l], heights[r]));
            if (heights[l] > heights[r]) {
                r--;
            } else if (heights[l] < heights[r]) {
                l++;
            } else {
                l++;
                r--;
            }
        }
        
        return res;
    }
}
