public class Solution {
    public boolean checkRecord(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'A') {
                cnt++;
                if (cnt >= 2) {
                    return false;
                }
            } else if (ch == 'L') {
                int j = i;
                while (j < s.length() && s.charAt(j) == 'L') {
                    j++;
                }
                
                if (j - i >= 3) {
                    return false;
                }
                
                i = j - 1;
            }
        }
        
        return true;
    }
}
