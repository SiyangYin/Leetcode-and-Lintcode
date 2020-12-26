import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() < p.length()) {
            return list;
        }
        
        int[] pChar = new int[26];
        int[] sChar = new int[26];
    
        for (int i = 0; i < p.length(); i++) {
            pChar[p.charAt(i) - 'a']++;
            sChar[s.charAt(i) - 'a']++;
        }
        // s[0,1,2,...,slen)
        // p[0,1,2,...,plen)
        
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (isAnagram(pChar, sChar)) {
                list.add(i);
            }
            if (i == s.length() - p.length()) {
                break;
            }
            sChar[s.charAt(i) - 'a']--;
            sChar[s.charAt(i + p.length()) - 'a']++;
        }
        
        return list;
    }
    
    private boolean isAnagram(int[] pChar, int[] sChar) {
        for (int i = 0; i < 26; i++) {
            if (pChar[i] != sChar[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Solution2().findAnagrams("cbaebabacd", "abc"));
        System.out.println(new Solution2().findAnagrams("abab", "ab"));
    }
}
