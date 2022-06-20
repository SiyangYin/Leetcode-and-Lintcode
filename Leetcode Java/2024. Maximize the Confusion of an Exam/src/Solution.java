public class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        return Math.max(calc(s, k, 'T'), calc(s, k, 'F'));
    }
    
    int calc(String s, int k, char ch) {
        int res = 0, cnt = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            cnt += s.charAt(i) == ch ? 1 : 0;
            while (cnt > k) {
                cnt -= s.charAt(j) == ch ? 1 : 0;
                j++;
            }
        
            res = Math.max(res, i - j + 1);
        }
    
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxConsecutiveAnswers("TFFT", 1));
    }
}
