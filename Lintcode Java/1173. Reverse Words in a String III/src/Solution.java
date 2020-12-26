public class Solution {
    /**
     * @param s: a string
     * @return: reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order
     */
    public String reverseWords(String s) {
        // Write your code here
        char[] str = s.toCharArray();
        for (int i = 0, j = 0; i <= str.length; i++) {
            if (i == str.length || str[i] == ' ') {
                reverse(str, j, i - 1);
                j = i + 1;
            }
        }
        
        return new String(str);
    }
    
    private void reverse(char[] s, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
