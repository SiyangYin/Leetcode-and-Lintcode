public class Solution {
    /**
     * @param str: a string containing uppercase alphabets and integer digits
     * @return: the alphabets in the order followed by the sum of digits
     */
    public String rearrange(String str) {
        // Write your code here
        if (str.isEmpty()) {
            return "";
        }
        
        int sum = 0;
        int[] count = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                count[ch - 'A']++;
            } else {
                sum += str.charAt(i) - '0';
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append((char) ('A' + i));
            }
        }
        
        return sb.append(sum).toString();
    }
}
