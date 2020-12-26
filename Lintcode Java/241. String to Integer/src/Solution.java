public class Solution {
    /**
     * @param target: A string
     * @return: An integer
     */
    public int stringToInteger(String target) {
        // write your code here
        int sign = target.charAt(0) == '-' ? -1 : 1;
        int res = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '-') {
                continue;
            }
            
            res = res * 10 + target.charAt(i) - '0';
        }
        
        return sign * res;
    }
}
