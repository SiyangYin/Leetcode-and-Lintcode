public class Solution {
    /**
     * @param s: a string
     * @return: whether the student could be rewarded according to his attendance record
     */
    public boolean checkRecord(String s) {
        // Write your code here
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
            }
            
            if (s.charAt(i) == 'L') {
                int countL = 0, j = i;
                while (j < s.length() && s.charAt(j) == 'L') {
                    countL++;
                    j++;
                }
                
                if (countL > 2) {
                    return false;
                }
                
                i = j - 1;
            }
        }
        
        return countA <= 1;
    }
}
