public class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128], tcount = new int[128];
        for (int i = 0; i < t.length(); i++) {
            tcount[t.charAt(i)]++;
        }
        
        int len = s.length() + 1;
        String res = "";
        for (int i = 0, j = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            
            while (j <= i && check(count, tcount)) {
                if (i - j + 1 < len) {
                    res = s.substring(j, i + 1);
                    len = i - j + 1;
                }
                
                count[s.charAt(j)]--;
                j++;
            }
        }
        
        return res;
    }
    
    private boolean check(int[] count, int[] tcount) {
        for (int i = 0; i < 128; i++) {
            if (count[i] < tcount[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
    }
}
