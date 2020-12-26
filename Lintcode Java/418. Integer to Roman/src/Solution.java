public class Solution {
    /**
     * @param n: The integer
     * @return: Roman representation
     */
    public String intToRoman(int n) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        String[] rome = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < val.length; i++) {
            while (n >= val[i]) {
                sb.append(rome[i]);
                n -= val[i];
            }
        }
        
        return sb.toString();
    }
}
