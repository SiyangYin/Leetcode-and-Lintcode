public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        
        int res = 0, l = timeSeries[0], r = l + duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (r >= timeSeries[i]) {
                r = Math.max(r, timeSeries[i] + duration);
            } else {
                res += r - l;
                l = timeSeries[i];
                r = l + duration;
            }
        }
        
        return res + r - l;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findPoisonedDuration(new int[]{1, 4}, 2));
    }
}
