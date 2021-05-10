public class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                int x = Integer.parseInt(s.substring(i, i + 2));
                sb.append((char) ('a' + x - 1));
                
                i = i + 2;
            } else {
                int x = s.charAt(i) - '0';
                sb.append((char) ('a' + x - 1));
            }
        }
        
        return sb.toString();
    }
}
