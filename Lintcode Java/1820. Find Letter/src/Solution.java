public class Solution {
    /**
     * @param str: the str
     * @return: the letter
     */
    public char findLetter(String str) {
        // Write your code here.
        if (str == null || str.isEmpty()) {
            return '~';
        }
    
        int lower = 0, upper = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                lower |= 1 << (str.charAt(i) - 'a');
            } else if (Character.isUpperCase(str.charAt(i))) {
                upper |= 1 << (str.charAt(i) - 'A');
            }
        }
        
        if ((lower & upper) == 0) {
            return '~';
        }
        
        int and = lower & upper;
        int count = 0;
        while (and != 1) {
            count++;
            and >>= 1;
        }
        
        return (char) ('A' + count);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findLetter("aAbBcD"));
    }
}
