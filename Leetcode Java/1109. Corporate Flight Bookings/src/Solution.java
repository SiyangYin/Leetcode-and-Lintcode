public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];
        for (int[] booking : bookings) {
            int l = booking[0] - 1, r = booking[1] - 1;
            diff[l] += booking[2];
            if (r + 1 < n) {
                diff[r + 1] -= booking[2];
            }
        }
        
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i > 0 ? diff[i] + res[i - 1] : diff[i];
        }
        
        return res;
    }
}
