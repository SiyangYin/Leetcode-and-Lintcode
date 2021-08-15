public class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.length() < s.length()) {
                sb.append(word);
            } else {
                break;
            }
        }
        
        return sb.toString().equals(s);
    }
}
