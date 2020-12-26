public class Solution {
    /**
     * @param s: A string
     * @return: the length of last word
     */
    public int lengthOfLastWord(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        if (i == -1) {
            return 0;
        }
        
        int end = i;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        
        return end - i;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("Hello World  "));
    }
}
