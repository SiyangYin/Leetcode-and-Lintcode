public class Solution {
    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        // write your code here
        if (str == null || str.length == 0) {
            return str;
        }
        
        int i = 0;
        while (i < str.length) {
            int j = i;
            while (j < str.length && str[j] != ' ') {
                j++;
            }
            
            reverse(str, i, j - 1);
            i = j + 1;
        }
        
        reverse(str, 0, str.length - 1);
        return str;
    }
    
    private void reverse(char[] str, int i, int j) {
        while (i < j) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            
            i++;
            j--;
        }
    }
}