public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().isPalindrome("."));
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    
        System.out.println(Character.toLowerCase('+'));
    }
}
