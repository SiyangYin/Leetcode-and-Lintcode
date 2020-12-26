public class Solution {
    /**
     * @param s: the string s
     * @return: the number of operations at least
     */
    public int numberOfOperations(String s) {
        // Write your code here
        int res = 0;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            res += Math.abs(s.charAt(j) - s.charAt(i));
        }
        
        return res;
    }
}
