import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MagicDictionary2 {
    
    private Set<String> set;
    
    /** Initialize your data structure here. */
    public MagicDictionary2() {
        set = new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        set.addAll(Arrays.asList(dict));
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int changed = 0;
        for (String s : set) {
            if (s.length() != word.length()) {
                continue;
            }
            
            changed = 0;
            for (int i = 0; i < word.length(); i++) {
                if (s.charAt(i) != word.charAt(i)) {
                    changed++;
                }
                
                if (changed >= 2) {
                    break;
                }
            }
            
            if (changed == 1) {
                return true;
            }
        }
        
        return false;
    }
}
