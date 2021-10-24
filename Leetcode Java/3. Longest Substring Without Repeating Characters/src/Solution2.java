public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] count = new int[128];
        
        for (int i = 0, j = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
            while (count[s.charAt(i)] > 1) {
                count[s.charAt(j)]--;
                j++;
            }
            
            res = Math.max(res, i - j + 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Character.MAX_VALUE);
        System.out.println((int) Character.MAX_VALUE);
    }
}
