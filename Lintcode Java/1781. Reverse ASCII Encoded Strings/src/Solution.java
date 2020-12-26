public class Solution {
    /**
     * @param encodeString: an encode string
     * @return: a reversed decoded string
     */
    public String reverseAsciiEncodedString(String encodeString) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < encodeString.length(); i += 2) {
            char t = encodeString.charAt(i), g = encodeString.charAt(i + 1);
            sb.append((char) ((t - '0') * 10 + g - '0'));
        }
        
        return sb.reverse().toString();
    }
}
