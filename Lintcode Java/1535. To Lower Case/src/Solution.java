public class Solution {
    /**
     * @param str: the input string
     * @return: The lower case string
     */
    public String toLowerCase(String str) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        int diff = 'A' - 'a';
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('A' <= ch && ch <= 'Z') {
                sb.append((char) (ch - diff));
            } else {
                sb.append(ch);
            }
        }
        
        return sb.toString();
    }
}
