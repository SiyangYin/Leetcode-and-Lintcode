public class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            
            sb.append(String.valueOf(s.charAt(i)).repeat(Math.min(2, j - i)));
            i = j - 1;
        }
        
        return sb.toString();
    }
}
