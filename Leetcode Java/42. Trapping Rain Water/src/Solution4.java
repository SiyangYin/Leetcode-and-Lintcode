import java.util.ArrayDeque;
import java.util.Deque;

public class Solution4 {
    public int trap(int[] height) {
        int lmax = 0;
        int rmax = height.length - 1;
        int imax = 0;
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[imax]) {
                imax = i;
            }
        }
        for (int i = 1; i < imax; i++) {
            if (height[i - 1] > height[lmax]) {
                lmax = i - 1;
            }
            res += Math.max(height[lmax] - height[i], 0);
        }
        for (int i = height.length - 2; i > imax; i--) {
            if (height[i + 1] > height[rmax]) {
                rmax = i + 1;
            }
            res += Math.max(height[rmax] - height[i], 0);
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        // height = new int[]{4, 0, 4};
        System.out.println(new Solution4().trap(height));
    }
}
