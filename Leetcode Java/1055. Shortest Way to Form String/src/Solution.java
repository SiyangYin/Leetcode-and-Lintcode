public class Solution {
    public int shortestWay(String source, String target) {
        int res = 0, idx = 0;
        int[][] auto = buildAuto(source);
        while (idx != target.length()) {
            int prev = idx;
            idx = delete(auto, target, idx);
            if (idx == prev) {
                return -1;
            }
            
            res++;
        }
        
        return res;
    }
    
    private int delete(int[][] auto, String t, int idx) {
        for (int pos = 0; idx < t.length(); idx++) {
            pos = auto[pos][t.charAt(idx) - 'a'];
            if (pos == 0) {
                break;
            }
        }
        
        return idx;
    }
    
    private int[][] buildAuto(String s) {
        int[][] auto = new int[s.length() + 1][26];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                auto[i][ch - 'a'] = auto[i + 1][ch - 'a'];
            }
            
            auto[i][s.charAt(i) - 'a'] = i + 1;
        }
        
        return auto;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().shortestWay("xyz", "xzyxz"));
        System.out.println(new Solution().shortestWay("abc", "abcbc"));
    }
}
