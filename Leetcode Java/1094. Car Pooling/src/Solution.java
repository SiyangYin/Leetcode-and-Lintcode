public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for (int[] trip : trips) {
            max = Math.max(max, trip[2]);
        }
        
        int[] diff = new int[max + 1];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }
        
        int sum = 0;
        for (int x : diff) {
            sum += x;
            if (sum > capacity) {
                return false;
            }
        }
        
        return true;
    }
}
