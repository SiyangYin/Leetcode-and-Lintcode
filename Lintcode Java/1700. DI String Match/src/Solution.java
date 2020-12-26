import java.util.Arrays;

public class Solution {
    public int[] diStringMatch(String S) {
        int len = S.length();
        int[] res = new int[len + 1];
        
        int l = 0, r = S.length();
        int idx = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res[idx++] = l++;
            } else {
                res[idx++] = r--;
            }
        }
        
        res[idx] = l;
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().diStringMatch("IDID")));
        System.out.println(Arrays.toString(new Solution().diStringMatch("III")));
    }
}
