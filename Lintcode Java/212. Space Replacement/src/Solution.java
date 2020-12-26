public class Solution {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // write your code here
        int len = 0;
        for (int i = 0; i < length; i++) {
            len += string[i] == ' ' ? 3 : 1;
        }
        
        for (int i = len - 1; i >= 0; i--) {
            if (string[length - 1] != ' ') {
                string[i] = string[length-- - 1];
            } else {
                string[i--] = '0';
                string[i--] = '2';
                string[i] = '%';
                length--;
            }
        }
        
        return len;
    }
    
    public static void main(String[] args) {
        char[] s = new char[17];
        String ss = "Mr John Smith";
        for (int i = 0; i < ss.length(); i++) {
            s[i] = ss.charAt(i);
        }
        
        new Solution().replaceBlank(s, 13);
    }
}
