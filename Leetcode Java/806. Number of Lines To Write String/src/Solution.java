public class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] res = {1, 0};
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += widths[s.charAt(i) - 'a'];
            if (cnt > 100) {
                cnt = 0;
                i--;
                res[0]++;
            }
        }
        
        res[1] = cnt;
        return res;
    }
}
