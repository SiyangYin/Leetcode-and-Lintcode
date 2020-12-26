public class Solution {
    /**
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // write your code here
        try {
            Double.parseDouble(s);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }
}
