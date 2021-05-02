import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        
        return res;
    }
}
