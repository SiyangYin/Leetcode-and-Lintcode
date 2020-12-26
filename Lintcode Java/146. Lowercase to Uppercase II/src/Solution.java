public class Solution {
    /**
     * @param str: A string
     * @return: A string
     */
    public String lowercaseToUppercase2(String str) {
        // write your code here
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i]) && 'a' <= chars[i] && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 'a' + 'A');
            }
        }
        
        return new String(chars);
    }
}
