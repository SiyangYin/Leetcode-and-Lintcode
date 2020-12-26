public class Solution {
    /**
     * @param timeSeries: the Teemo's attacking ascending time series towards Ashe
     * @param duration:   the poisoning time duration per Teemo's attacking
     * @return: the total time that Ashe is in poisoned condition
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // Write your code here
        int res = 0;
        int[] interval = {0, 0};
        for (int i = 0; i < timeSeries.length; i++) {
            int start = timeSeries[i], end = start + duration;
            
            if (start > interval[1]) {
                res += interval[1] - interval[0];
                interval[0] = start;
                interval[1] = end;
            } else {
                interval[1] = end;
            }
        }
        
        res += interval[1] - interval[0];
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] ti = {1, 2};
        int du = 2;
        System.out.println(new Solution().findPoisonedDuration(ti, du));
    }
}
