public class Solution {
    public boolean isDecomposable(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            
            if ((j - i) % 3 == 1) {
                return false;
            }
            
            if ((j - i) % 3 == 2) {
                cnt++;
            }
            
            if (cnt > 1) {
                return false;
            }
            
            i = j - 1;
        }
        
        return cnt == 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isDecomposable("00011111222"));
    }
}
