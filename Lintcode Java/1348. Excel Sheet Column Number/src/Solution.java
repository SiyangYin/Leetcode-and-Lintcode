public class Solution {
    /**
     * @param s: a string
     * @return: return a integer
     */
    public int titleToNumber(String s) {
        // write your code here
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res = res * 26 + ch - 'A' + 1;
        }
        
        return res;
    }
}
