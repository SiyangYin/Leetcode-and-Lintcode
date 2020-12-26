public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E), right = Math.min(C, G);
        int low = Math.max(B, F), up = Math.min(D, H);
        
        int sum = (C - A) * (D - B) + (G - E) * (H - F);
        
        if (right <= left || up <= low) {
            return sum;
        }
        
        int overlap = (right - left) * (up - low);
        return sum - overlap;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(new Solution().computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }
}
