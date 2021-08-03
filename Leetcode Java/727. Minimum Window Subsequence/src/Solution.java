public class Solution {
    public String minWindow(String s1, String s2) {
        int[][] dfa = buildDFA(s1);
        String res = "";
        int idx = 0, end = 0;
        while ((end = compute(idx, dfa, s2)) != 0) {
            int begin = dfa[idx][s2.charAt(0) - 'a'];
            if (res.isEmpty() || end - begin + 1 < res.length()) {
                res = s1.substring(begin - 1, end);
            }
            
            idx = begin;
        }
        
        return res;
    }
    
    private int compute(int idx, int[][] dfa, String s) {
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            if (dfa[idx][x] == 0) {
                return 0;
            }
            
            idx = dfa[idx][x];
        }
        
        return idx;
    }
    
    private int[][] buildDFA(String s) {
        int[][] dfa = new int[s.length() + 1][26];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                dfa[i][j] = dfa[i + 1][j];
            }
            
            dfa[i][s.charAt(i) - 'a'] = i + 1;
        }
        
        return dfa;
    }
    
    public static void main(String[] args) {
        String s1 = "abcdebdde", s2 = "bde";
        System.out.println(new Solution().minWindow(s1, s2));
    }
}
