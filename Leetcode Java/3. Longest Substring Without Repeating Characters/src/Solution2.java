public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] count = new int[256];
    
        for (int j = 0, i = 0; i < s.length(); i++) {
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
        for (int i = 0; i < 256; i++) {
            System.out.print((char) i + " ");
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}
