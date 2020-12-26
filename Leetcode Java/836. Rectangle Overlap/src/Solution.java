public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int left = Math.max(rec1[0], rec2[0]), right = Math.min(rec1[2], rec2[2]);
        int low = Math.max(rec1[1], rec2[1]), up = Math.min(rec1[3], rec2[3]);
        
        return !(left >= right || low >= up);
    }
}
