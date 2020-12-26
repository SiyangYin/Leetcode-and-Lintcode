import java.util.*;

public class Solution {
    public String[] findWords(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<Character>[] sets = (HashSet<Character>[]) new HashSet[3];
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        for (int i = 0; i < rows.length; i++) {
            sets[i] = new HashSet<>();
            for (int j = 0; j < rows[i].length(); j++) {
                sets[i].add(rows[i].charAt(j));
            }
        }
    
        for (int i = 0; i < words.length; i++) {
            int row = 0;
            for (int j = 0; j < words[i].length(); j++) {
                char ch = Character.toLowerCase(words[i].charAt(j));
                if (sets[0].contains(ch)) {
                    row |= 1;
                }
                if (sets[1].contains(ch)) {
                    row |= 2;
                }
                if (sets[2].contains(ch)) {
                    row |= 8;
                }
            }
            
            if (row == 1 || row == 2 || row == 8) {
                ans.add(words[i]);
            }
        }
        
        String[] res = new String[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}
