public class Solution {
    /**
     * @param s: the string
     * @return: Min Deletions To Obtain String in Right Format
     */
    public int minDeletionsToObtainStringInRightFormat(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int countA = 0, countB = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                countB++;
            }
        }
    
        int res = s.length() - countB;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'B') {
                countB--;
            } else {
                countA++;
            }
            
            res = Math.min(res, s.length() - countA - countB);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minDeletionsToObtainStringInRightFormat("BBABAA"));
    }
}
