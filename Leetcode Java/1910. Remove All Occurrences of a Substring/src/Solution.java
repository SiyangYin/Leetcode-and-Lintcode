public class Solution {
    public String removeOccurrences(String s, String part) {
        int[] ne = buildNext(part);
        int pos = -1;
        while ((pos = kmp(s, part, ne)) != -1) {
            s = s.substring(0, pos) + s.substring(pos + part.length());
        }
        
        return s;
    }
    
    private int kmp(String s, String p, int[] ne) {
        for (int i = 0, j = 0; i < s.length(); ) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = ne[j];
            }
            
            if (j == p.length()) {
                return i - j;
            }
        }
        
        return -1;
    }
    
    private int[] buildNext(String p) {
        int[] ne = new int[p.length()];
        for (int i = 0, j = ne[0] = -1; i < p.length() - 1; ) {
            if (j == -1 || p.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                ne[i] = p.charAt(i) != p.charAt(j) ? j : ne[j];
            } else {
                j = ne[j];
            }
        }
        
        return ne;
    }
}
