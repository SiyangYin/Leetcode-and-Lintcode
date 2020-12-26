public class Solution {
    /**
     * @param newTime: new time
     * @return: maximum time
     */
    public char[] timeMagic(char[] newTime) {
        // Write your code here
        for (int i = 0; i < newTime.length; i++) {
            if (newTime[i] == '?') {
                if (i == 0) {
                    newTime[0] = newTime[1] == '?' || newTime[1] <= '3' ? '2' : '1';
                } else if (i == 1) {
                    newTime[1] = newTime[0] <= '1' ? '9' : '3';
                } else if (i == 3) {
                    newTime[3] = '5';
                } else if (i == 4) {
                    newTime[4] = '9';
                }
            }
        }
        
        return newTime;
    }
}
