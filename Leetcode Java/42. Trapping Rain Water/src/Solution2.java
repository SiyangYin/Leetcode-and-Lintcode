public class Solution2 {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        
        int res = 0;
        
        int[] dpl = new int[height.length], dpr = new int[height.length];
        dpl[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            dpl[i] = Math.max(dpl[i - 1], height[i - 1]);
        }
        dpr[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            dpr[i] = Math.max(dpr[i + 1], height[i + 1]);
        }
        
        for (int i = 0; i < height.length; i++) {
            res += Math.max(0, Math.min(dpl[i], dpr[i]) - height[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().trap(new int[]{2, 0, 1, 3}));
        System.out.println(new Solution2().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
