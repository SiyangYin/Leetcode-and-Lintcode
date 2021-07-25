public class Solution {
    public boolean isSelfCrossing(int[] d) {
        if (d.length <= 3) {
            return false;
        }
        
        for (int i = 3; i < d.length; i++) {
            if (d[i - 1] <= d[i - 3] && d[i - 2] <= d[i]) {
                return true;
            }
            if (i >= 4 && d[i - 3] == d[i - 1] && d[i] + d[i - 4] >= d[i - 2]) {
                return true;
            }
            if (i >= 5 && d[i - 3] >= d[i - 1] && d[i - 1] + d[i - 5] >= d[i - 3] && d[i - 2] > d[i - 4] && d[i - 4] + d[i] >= d[i - 2]) {
                return true;
            }
        }
        
        return false;
    }
}
