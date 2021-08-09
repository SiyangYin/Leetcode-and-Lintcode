import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param words:    an array of string
     * @param maxWidth: a integer
     * @return: format the text such that each line has exactly maxWidth characters and is fully
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        // write your code here
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
                
                for (int k = maxWidth - sb.length(); k > 0; k--) {
                    sb.append(' ');
                }
            } else {
                int cnt = j - i, sp = maxWidth - len + cnt - 1;
                sb.append(words[i]);
                for (int k = 0; k < cnt - 1; k++) {
                    for (int l = 0; l < sp / (cnt - 1); l++) {
                        sb.append(' ');
                    }
                    if (k < sp % (cnt - 1)) {
                        sb.append(' ');
                    }
                    
                    sb.append(words[i + 1 + k]);
                }
            }
            
            res.add(sb.toString());
            i = j - 1;
        }
        
        return res;
    }
}
