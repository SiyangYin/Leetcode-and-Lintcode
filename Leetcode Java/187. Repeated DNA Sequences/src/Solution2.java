import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<Long> set = new HashSet<>();
        
        long p = 131;
        if (s.length() < 10) {
            return new ArrayList<>();
        }
    
        long hash = 0, pow = 1;
        for (int i = 0; i < 10; i++) {
            hash = hash * p + s.charAt(i);
            pow *= p;
        }
        
        set.add(hash);
        for (int i = 10; i < s.length(); i++) {
            hash = hash * p + s.charAt(i);
            hash -= pow * s.charAt(i - 10);
            
            if (set.contains(hash)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                set.add(hash);
            }
        }
        
        return new ArrayList<>(res);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
