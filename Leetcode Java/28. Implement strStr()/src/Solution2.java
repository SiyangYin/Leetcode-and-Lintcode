public class Solution2 {
    public int strStr(String s, String p) {
        if (p.isEmpty()) {
            return 0;
        }
        
        int[] ne = buildNe(p);
        for (int i = 0, j = 0; i < s.length(); ) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
                if (j == p.length()) {
                    return i - j;
                }
            } else {
                j = ne[j];
            }
        }
        
        return -1;
    }
    
    private int[] buildNe(String p) {
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
