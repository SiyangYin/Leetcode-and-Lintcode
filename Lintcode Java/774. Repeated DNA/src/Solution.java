import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    /**
     * @param s: a string represent DNA sequences
     * @return: all the 10-letter-long sequences
     */
    public List<String> findRepeatedDna(String s) {
        // write your code here
        List<String> res = new ArrayList<>();
        
        if (s.length() <= 10) {
            return res;
        }
        
        Set<Long> set = new HashSet<>();
        
        long POW = pow(31, 9);
    
        long hash = 0;
        for (int i = 0; i < 10; i++) {
            hash = hash * 31 + s.charAt(i) - 'A' + 1;
        }
        
        set.add(hash);
    
        Set<Long> tmp = new HashSet<>();
        for (int i = 10; i < s.length(); i++) {
            hash -= (s.charAt(i - 10) - 'A' + 1) * POW;
            hash = hash * 31 + s.charAt(i) - 'A' + 1;
            
            if (set.contains(hash)) {
                tmp.add(hash);
            } else {
                set.add(hash);
            }
        }
    
        for (Long l : tmp) {
            res.add(recover(l));
        }
        
        return res;
    }
    
    private String recover(long s) {
        StringBuilder sb = new StringBuilder();
        while (s > 0) {
            sb.append((char) (s % 31 + 'A' - 1));
            s /= 31;
        }
        
        return sb.reverse().toString();
    }
    
    private long pow(int base, int power) {
        long res = 1;
        for (int i = 0; i < power; i++) {
            res *= base;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().findRepeatedDna("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(new Solution().findRepeatedDna(""));
    }
}
