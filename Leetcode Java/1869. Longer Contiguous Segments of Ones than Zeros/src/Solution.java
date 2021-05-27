public class Solution {
    public boolean checkZeroOnes(String s) {
        int ones = 0, zeros = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                int j = i;
                while (j < s.length() && s.charAt(j) == ch) {
                    j++;
                }
                
                ones = Math.max(ones, j - i);
                i = j - 1;
            } else {
                int j = i;
                while (j < s.length() && s.charAt(j) == ch) {
                    j++;
                }
                
                zeros = Math.max(zeros, j - i);
                i = j - 1;
            }
        }
        
        return ones > zeros;
    }
}
