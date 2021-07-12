import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            int j = i + 1, len = words[i].length();
            while (j < words.length && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j].length();
                j++;
            }
            
            StringBuilder sb = new StringBuilder();
            if (j == words.length || j == i + 1) {
                sb.append(words[i]);
                for (int k = i + 1; k < j; k++) {
                    sb.append(' ').append(words[k]);
                }
                sb.append(" ".repeat(maxWidth - sb.length()));
            } else {
                int cnt = j - i - 1, r = maxWidth - len + cnt;
                sb.append(words[i]);
                int k = 0;
                while (k < r % cnt) {
                    sb.append(" ".repeat(Math.max(0, r / cnt + 1))).append(words[i + k + 1]);
                    k++;
                }
                while (k < cnt) {
                    sb.append(" ".repeat(Math.max(0, r / cnt))).append(words[i + k + 1]);
                    k++;
                }
            }
            
            res.add(sb.toString());
            i = j - 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] w = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxw = 14;
        List<String> strings = new Solution().fullJustify(w, maxw);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
