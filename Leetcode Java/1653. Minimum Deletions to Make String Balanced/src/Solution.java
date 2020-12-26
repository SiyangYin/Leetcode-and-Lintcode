public class Solution {
    public int minimumDeletions(String s) {
        int aCount = 0, bCount = 0;
        for (int i = 0; i < s.length(); i++) {
            aCount += s.charAt(i) == 'a' ? 1 : 0;
        }
        
        int res = aCount;
        for (int i = 0; i < s.length(); i++) {
            bCount += s.charAt(i) == 'b' ? 1 : 0;
            aCount -= s.charAt(i) == 'a' ? 1 : 0;
            res = Math.min(res, bCount + aCount);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minimumDeletions("aababbab"));
    }
}
