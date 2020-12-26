import java.util.Arrays;

public class Solution {
    /**
     * @param t:   the length of the flight
     * @param dur: the length of movies
     * @return: output the lengths of two movies
     */
    public int[] aerialMovie(int t, int[] dur) {
        // Write your code here
        int[] res = new int[2];
        
        t -= 30;
        Arrays.sort(dur);
        int l = 0, r = dur.length - 1;
        while (l < r) {
            if (dur[l] + dur[r] > t) {
                r--;
            } else {
                if (dur[l] + dur[r] > res[0] + res[1]) {
                    res[0] = dur[l];
                    res[1] = dur[r];
                }
                
                l++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().aerialMovie(87, new int[]{20, 25, 19, 37})));
    }
}
