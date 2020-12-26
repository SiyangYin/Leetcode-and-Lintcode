import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            res.add(match(query, pattern));
        }
        
        return res;
    }
    
    private boolean match(String word, String pattern) {
        int i = 0, j = 0;
        while (i < word.length() && j < pattern.length()) {
            char w = word.charAt(i), p = pattern.charAt(j);
            if (w == p) {
                i++;
                j++;
            } else if (Character.isUpperCase(w)) {
                return false;
            } else {
                i++;
            }
        }
        
        if (j < pattern.length()) {
            return false;
        }
        
        if (i < word.length()) {
            while (i < word.length()) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
                i++;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String[] q = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        System.out.println(new Solution2().camelMatch(q, "FoBaT"));
    }
}
