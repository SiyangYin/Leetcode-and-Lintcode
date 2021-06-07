public class Solution {
    /**
     * @param str: the given string
     * @return: the maximum value
     */
    public int calcMaxValue(String str) {
        // write your code here
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            int x = str.charAt(i) - '0';
            if (x <= 1 || res <= 1) {
                res += x;
            } else {
                res *= x;
            }
        }
        
        return res;
    }
}
