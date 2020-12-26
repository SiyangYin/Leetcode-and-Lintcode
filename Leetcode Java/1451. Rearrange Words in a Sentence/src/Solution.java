import java.util.Arrays;

public class Solution {
    public String arrangeWords(String text) {
        String[] ss = text.split(" ");
        Arrays.sort(ss, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append(ss[i].toLowerCase()).append(' ');
        }
        
        sb.setLength(sb.length() - 1);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }
}
