public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char res = 0;
        int max = 0;
        for (int i = 0; i < releaseTimes.length; i++) {
            int curMax = i > 0 ? releaseTimes[i] - releaseTimes[i - 1] : releaseTimes[0];
            if (curMax > max) {
                max = curMax;
                res = keysPressed.charAt(i);
            } else if (curMax == max) {
                res = (char) Math.max(res, keysPressed.charAt(i));
            }
        }
        
        return res;
    }
}
